/**
 * 
 */
package org.jbehaviour;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.jbehaviour.exception.JBehaviourPasingError;
import org.jbehaviour.exception.JBehaviourRuntimeError;
import org.jbehaviour.parser.JBehaviourParser;
import org.jbehaviour.parser.model.FormalStory;
import org.jbehaviour.parser.model.IKeywordStatement;
import org.jbehaviour.parser.model.impl.KeywordScenario;
import org.jbehaviour.reflexion.IBehaviourReflexion;
import org.jbehaviour.reflexion.IBehaviourReflexionContext;
import org.jbehaviour.reflexion.impl.JBehaviourReflexion;
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
	 * @throws JBehaviourPasingError 
	 * @throws IOException 
	 * @throws InstantiationException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws JBehaviourRuntimeError 
	 */
	public static void main(String[] args) throws IOException, JBehaviourPasingError, ClassNotFoundException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException, JBehaviourRuntimeError {
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

	/**
	 * @param args
	 * @return 
	 * @throws IOException 
	 * @throws JBehaviourPasingError 
	 * @throws ClassNotFoundException 
	 * @throws JBehaviourRuntimeError 
	 * @throws InstantiationException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public static boolean registerAndExecute(String story) throws JBehaviourPasingError, JBehaviourRuntimeError {
		/**
		 * story parser
		 */
		FormalStory parsedStory;
		try {
			parsedStory = (new JBehaviourParser(story)).parse();
		} catch (JBehaviourPasingError e) {
			e.printStackTrace();
			return false;
		}
		
		/**
		 * reflexion manager
		 */
		IBehaviourReflexion registry = new JBehaviourReflexion();
		for(IKeywordStatement include : parsedStory.getFeature().getKeywordInclude()) {
			/**
			 * include all this object in current
			 * transaction
			 */
			FormalStory includeStory = null;
			try {
				includeStory = (new JBehaviourParser(include.getReference())).parse();
			} catch (JBehaviourPasingError e) {
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
			} catch (JBehaviourPasingError e) {
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
					stepToExecute = registry.retrieve(step.getType(),step.getStatement());
				} catch (JBehaviourPasingError e) {
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
						ret = stepToExecute.execute();
					} catch (JBehaviourPasingError e) {
						e.printStackTrace();
						return false;
					} catch (JBehaviourRuntimeError e) {
						e.printStackTrace();
						return false;
					}
					logger.info("Result is " + ret);
				} else {
					logger.error("Unable to find step " + step.getStatement());
					return false;
				}
			}
		}
		return true;
	}
}
