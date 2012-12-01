/**
 * 
 */
package org.jbehaviour;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.jbehaviour.exception.JBehaviourParsingError;
import org.jbehaviour.exception.JBehaviourRuntimeError;
import org.jbehaviour.parser.JBehaviourParser;
import org.jbehaviour.parser.model.FormalStory;
import org.jbehaviour.parser.model.IKeywordStatement;
import org.jbehaviour.parser.model.impl.KeywordReport;
import org.jbehaviour.parser.model.impl.KeywordScenario;
import org.jbehaviour.reflexion.IBehaviourReflexion;
import org.jbehaviour.reflexion.IBehaviourReflexionContext;
import org.jbehaviour.reflexion.impl.JBehaviourReflexion;
import org.jbehaviour.report.IBehaviourReport;
import org.jbehaviour.report.IBehaviourReportRun;
import org.jbehaviour.xref.IBehaviourXRefSuite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Yannick
 *
 */
public class JBehaviourLauncher {
	static Logger logger = LoggerFactory.getLogger(JBehaviourLauncher.class);

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws JBehaviourParsingError 
	 * @throws IOException 
	 * @throws InstantiationException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws JBehaviourRuntimeError 
	 */
	public static void main(String[] args) throws IOException, JBehaviourParsingError, ClassNotFoundException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException, JBehaviourRuntimeError {
		System.out.println("JBehaviourLauncher 1.0\nusage: JBehaviourLauncher --story <story file>\n");
		String story = null;
		/**
		 * command line analysis
		 */
		int index = 0;
		for(String argument : args) {
			if("-s".compareTo(argument)==0 || "--story".compareTo(argument)==0) {
				story = args[index+1];
			}
			index++;
		}

		if(!registerAndExecute(story)) {
			System.err.println("Fail to execute this story");
		}
	}

	public static boolean registerAndExecute(String story) throws JBehaviourParsingError, JBehaviourRuntimeError {
		/**
		 * story parser
		 */
		FormalStory parsedStory;
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

		IBehaviourReflexion registry = new JBehaviourReflexion();
		boolean result = registerAndExecuteStory(story, parsedStory, registry);
		
		/**
		 * dump xref
		 */
		registry.getXRef().setName(new File(story).getName());
		for(IKeywordStatement item : parsedStory.getFeature().getKeywordReports()) {
			KeywordReport report = (KeywordReport) item;
			logger.info("Report: " + report.getKlass());
			logger.info("Template: " + report.getTemplate());
			logger.info("Output: " + report.getOutputFile());
			try {
				IBehaviourReport myReport = (IBehaviourReport) Class.forName(report.getKlass()).newInstance();
				myReport.init();
				myReport.render(registry, new File(report.getTemplate()), new File(report.getOutputFile()));
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

		for(String key : registry.getXRef().getRunsByScenario().keySet()) {
			IBehaviourXRefSuite suite = registry.getXRef().getRunsByScenario().get(key);
			for(IBehaviourReportRun run : suite.getRuns()) {
				logger.info("name: " + run.getName());
				logger.info("duration: " + run.getDuration());
				logger.info("object: " + run.getObject());
				logger.info("args: " + run.getArgs());
				logger.info("text: " + run.getText());
				logger.info("klass: " + run.getKlass());
				logger.info("text like: " + run.getTextLikeMethod());
			}
		}

		return result;
	}
	
	public static boolean registerAndExecuteStory(String story, FormalStory parsedStory, IBehaviourReflexion registry) throws JBehaviourParsingError, JBehaviourRuntimeError {
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
				registry.register(register.getReference(),register.getKlass());
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
					registry.declareString(declare.getReference(),declare.extractLiteralAsString(3));
					break;
				case Json:
					registry.declareJson(declare.getReference(),declare.extractLiteralAsString(3),declare.get(4).getValue());
					break;
				default:
					throw new JBehaviourRuntimeError("Type " + declare.getDeclareType() + " unknown" );
			}
		}

		/**
		 * now scenario by scenario execute all of them
		 */
		IBehaviourReflexionContext stepToExecute = null;
		for(KeywordScenario scenario : parsedStory.getScenarios()) {
			for(IKeywordStatement step : scenario.getKeywords()) {
				logger.info("step: " + step.getStatement());
				try {
					stepToExecute = registry.retrieve(scenario.getTextLikeMethod(),step.getType(),step.getStatement());
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
						ret = stepToExecute.execute();
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
								throw new JBehaviourRuntimeError("Return on Then keyword cannot be null !!!");
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
		}
		
		return true;
	}
}
