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

import org.jbehaviour.IBehaviourLauncher;
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
		for(KeywordScenario scenario : parsedStory.getScenarios()) {
			return execute(scenario);
		}
		
		return true;
	}

	@Override
	public boolean execute(KeywordScenario scenario) throws JBehaviourRuntimeError {
		IBehaviourReflexionContext stepToExecute = null;
		for(IKeywordStatement step : scenario.getKeywords()) {
			logger.info("Step runnning : " + step.getStatement());
			try {
				stepToExecute = env.getRef().retrieve(scenario.getTextLikeMethod(),step.getType(),step.getStatement());
			} catch (JBehaviourParsingError e) {
				e.printStackTrace();
				return false;
			} catch (JBehaviourRuntimeError e) {
				e.printStackTrace();
				return false;
			}
			/**
			 * if found run it
			 */
			if(stepToExecute != null) {
				Object ret;
				try {
					/**
					 * we have found this step, no we can execute
					 * it
					 */
					ret = stepToExecute.execute(env);
				} catch (JBehaviourParsingError e) {
					e.printStackTrace();
					return false;
				} catch (JBehaviourRuntimeError e) {
					e.printStackTrace();
					return false;
				}
				logger.info("Result is " + ret);
				switch(stepToExecute.getType()) {
					case Given:
					case Store:
					case When:
						/**
						 * Given, Store and When return value have
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
							throw new JBehaviourRuntimeError(stepToExecute.toString() + " : return on Then keyword cannot be null !!!");
						}
						if((Boolean) ret == false) return (Boolean) ret;
					default:
						break;
				}
			} else {
				/**
				 * fatal error
				 * step is not found in registry
				 */
				logger.error("Unable to find step " + step.getStatement());
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean executeByStatement(String name) throws JBehaviourRuntimeError {
		for(KeywordScenario scenario : parsedStory.getScenarios()) {
			if(scenario.getStatement().compareTo(name) == 0) {
				return execute(scenario);
			}
		}
		return false;
	}
}
