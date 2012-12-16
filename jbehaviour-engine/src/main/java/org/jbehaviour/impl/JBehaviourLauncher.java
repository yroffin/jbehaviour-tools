/**
 *  Copyright 2012 Yannick Roffin
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package org.jbehaviour.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.jbehaviour.IBehaviourLauncher;
import org.jbehaviour.IBehaviourScenario;
import org.jbehaviour.exception.JBehaviourParsingError;
import org.jbehaviour.exception.JBehaviourRuntimeError;
import org.jbehaviour.parser.JBehaviourParser;
import org.jbehaviour.parser.model.FormalStory;
import org.jbehaviour.parser.model.IKeywordStatement;
import org.jbehaviour.parser.model.impl.KeywordReport;
import org.jbehaviour.parser.model.impl.KeywordScenario;
import org.jbehaviour.reflexion.IBehaviourReflexionContext;
import org.jbehaviour.reflexion.impl.JBehaviourEnv;
import org.jbehaviour.reflexion.impl.JBehaviourReflexion;
import org.jbehaviour.report.IBehaviourReport;
import org.jbehaviour.xref.impl.JBehaviourXRef;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * this class implement the main of this system
 */
public class JBehaviourLauncher implements IBehaviourLauncher {
	static Logger logger = LoggerFactory.getLogger(JBehaviourLauncher.class);
	private JBehaviourEnv env;

	private List<IBehaviourScenario> scenarios = new ArrayList<IBehaviourScenario>();
	private Map<String,IBehaviourScenario> scenariosByName = new HashMap<String,IBehaviourScenario>();
	private Stack<IBehaviourScenario> stack = new Stack<IBehaviourScenario>();

	/**
	 * constructor
	 * @throws JBehaviourParsingError
	 */
	public JBehaviourLauncher() throws JBehaviourParsingError {
		env = new JBehaviourEnv(this,new JBehaviourReflexion(),new JBehaviourXRef());
	}

	FormalStory parsedStory = null;

	@Override
	public FormalStory getParsedStory() {
		return parsedStory;
	}

	@Override
	public boolean registerAndExecute(String story) throws JBehaviourParsingError, JBehaviourRuntimeError {
		/**
		 * story parser
		 */
		try {
			parsedStory = (new JBehaviourParser(story)).parse();
		} catch (JBehaviourParsingError e) {
			e.printStackTrace();
			return false;
		}

		/**
		 * check for report configuration
		 */
		for(IKeywordStatement item : parsedStory.getFeature().getKeywordReports()) {
			KeywordReport report = (KeywordReport) item;
			/**
			 * check for class existence
			 */
			try {
				Class.forName(report.getKlass()).newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
				throw new JBehaviourParsingError(e);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				throw new JBehaviourParsingError(e);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				throw new JBehaviourParsingError(e);
			}
			if(!(new File(report.getTemplate()).exists())) {
				throw new JBehaviourParsingError("No template file " + report.getTemplate());
			}
		}

		/**
		 * read and execute it
		 */
		boolean result = registerAndExecuteStory(story, parsedStory);
		
		/**
		 * dump xref
		 * xref have collected all statistics elements during
		 * story run
		 */
		env.getXRef().setName(new File(story).getName());
		for(IKeywordStatement item : parsedStory.getFeature().getKeywordReports()) {
			KeywordReport report = (KeywordReport) item;
			logger.info("Report: " + report.getKlass());
			logger.info("Template: " + report.getTemplate());
			logger.info("Output: " + report.getOutputFile());
			try {
				IBehaviourReport myReport = (IBehaviourReport) Class.forName(report.getKlass()).newInstance();
				myReport.init();
				myReport.render(env.getRef(), new File(report.getTemplate()), new File(report.getOutputFile()));
			} catch (InstantiationException e) {
				e.printStackTrace();
				return false;
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				return false;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				return false;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}

		return result;
	}
	
	@Override
	public boolean registerAndExecuteStory(String story, FormalStory parsedStory) throws JBehaviourParsingError, JBehaviourRuntimeError {
		/**
		 * reflexion manager
		 */
		for(IKeywordStatement include : parsedStory.getFeature().getKeywordInclude()) {
			/**
			 * include all this object in current
			 * transaction
			 */
			FormalStory includeStory = null;
			try {
				includeStory = (new JBehaviourParser(include.getReference())).parse();
			} catch (JBehaviourParsingError e) {
				e.printStackTrace();
				return false;
			}
			/**
			 * add all register, declare ... of this story in current
			 */
			parsedStory.getFeature().includeRegister(includeStory.getFeature().getKeywordRegister());
			parsedStory.getFeature().includeDeclare(includeStory.getFeature().getKeywordDeclare());
			for(KeywordScenario scenario : includeStory.getScenarios()) {
				parsedStory.getScenarios().add(scenario);
			}
		}
		for(IKeywordStatement register : parsedStory.getFeature().getKeywordRegister()) {
			try {
				env.getRef().register(register.getReference(),register.getKlass());
			} catch (JBehaviourParsingError e) {
				e.printStackTrace();
				return false;
			}
		}

		logger.info("Class registred: " + parsedStory.getFeature().getKeywordRegister().size());

		/**
		 * run variable declararion
		 */
		for(IKeywordStatement declare : parsedStory.getFeature().getKeywordDeclare()) {
			switch(declare.getDeclareType()) {
				case String:
					env.getRef().declareString(declare.getReference(),declare.extractLiteralAsString(3));
					break;
				case Json:
					env.getRef().declareJson(declare.getReference(),declare.extractLiteralAsString(3),declare.get(4).getValue());
					break;
				default:
					throw new JBehaviourRuntimeError("Type " + declare.getDeclareType() + " unknown" );
			}
		}

		/**
		 * now scenario by scenario execute all of them
		 */
		for(KeywordScenario parsedScenario : parsedStory.getScenarios()) {
			String key = parsedScenario.getStatement();
			if(scenariosByName.containsKey(key)) {
				logger.error("Scenario statement must be unique : " + key);
				throw new JBehaviourRuntimeError("Scenario statement must be unique : " + key);
			} else {
				IBehaviourScenario s = compile(parsedScenario);
				scenariosByName.put(key, s);
				scenarios.add(s);				
			}
		}
		/**
		 * fix calling stack
		 */
		for(IBehaviourScenario scenario : scenarios) {
			scenario.setCallers(scenarios);
		}
		/**
		 * execute all scenarios
		 */
		boolean result = true;
		for(IBehaviourScenario key : scenarios) {
			/**
			 * only primary scenario can be executed
			 * (called scenario are not directly run)
			 */
			if(key.getCallers().size() == 0) {
				result = result & executeByStatement(key.getStatement());
			}
		}
		
		/**
		 * global result
		 */
		return result;
	}

	@Override
	public IBehaviourScenario compile(KeywordScenario parsedScenario) throws JBehaviourRuntimeError {
		IBehaviourScenario scenario = new JBehaviourScenario(parsedScenario);
		IBehaviourReflexionContext context = null;
		for(IKeywordStatement step : parsedScenario.getKeywords()) {
			logger.info("Compile : " + step.getStatement());
			try {
				context = env.getRef().retrieve(parsedScenario.getTextLikeMethod(),step.getType(),step.getStatement());
			} catch (JBehaviourParsingError e) {
				e.printStackTrace();
				throw new JBehaviourRuntimeError(e);
			} catch (JBehaviourRuntimeError e) {
				e.printStackTrace();
				throw e;
			}
			/**
			 * context must be found
			 */
			if(context == null) {
				logger.error("Unable to find step " + step.getStatement());
				throw new JBehaviourRuntimeError("Unable to find step " + step.getStatement());
			} else {
				scenario.add(context);
			}
		}
		return scenario;
	}

	@Override
	public boolean execute(IBehaviourScenario scenario) throws JBehaviourRuntimeError {
		/**
		 * push this call in the call stack
		 */
		stack.push(scenario);
		try {
			logger.info("Scenario running : " + scenario.getStatement() + " / " + stack.size() + " / " + scenario.getCallers());
			if(logger.isDebugEnabled()) {
				StringBuilder sLevel = new StringBuilder();
				for(IBehaviourScenario item : stack) {
					logger.info(sLevel.toString() + "[+] " + item.getStatement());
					sLevel.append("    ");
				}
			}
			for(IBehaviourReflexionContext step : scenario.getContexts()) {
				logger.info("Step running : " + step.getStatement());
				Object ret = null;
				try {
					/**
					 * we have found this step, no we can execute
					 * it
					 */
					ret = step.execute(env);
				} catch (JBehaviourParsingError e) {
					e.printStackTrace();
					return false;
				} catch (JBehaviourRuntimeError e) {
					e.printStackTrace();
					return false;
				}
				logger.info("Result is " + ret);
				switch(step.getType()) {
					case Given:
					case Call:
					case When:
						/**
						 * Given, Call and When return value have
						 * no action on the execution
						 */
						break;
					case Then:
						/**
						 * Then statement are special statement, because
						 * return must be analyzed and checked to continue
						 * false break the scenario/story execution
						 */
						if(ret == null) {
							throw new JBehaviourRuntimeError(step.toString() + " : return on Then keyword cannot be null !!!");
						}
						if((Boolean) ret == false) return (Boolean) ret;
					default:
						break;
				}
			}
			return true;
		} finally {
			stack.pop();
		}
	}

	@Override
	public boolean executeByStatement(String name) throws JBehaviourRuntimeError {
		return execute(scenariosByName.get(name));
	}
}
