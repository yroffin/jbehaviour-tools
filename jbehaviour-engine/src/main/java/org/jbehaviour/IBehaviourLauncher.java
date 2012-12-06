package org.jbehaviour;

import org.jbehaviour.exception.JBehaviourParsingError;
import org.jbehaviour.exception.JBehaviourRuntimeError;
import org.jbehaviour.parser.model.FormalStory;
import org.jbehaviour.parser.model.impl.KeywordScenario;

public interface IBehaviourLauncher {

	/**
	 * register and execute it
	 * @param story
	 * @return
	 * @throws JBehaviourParsingError
	 * @throws JBehaviourRuntimeError
	 */
	public abstract boolean registerAndExecute(String story)
			throws JBehaviourParsingError, JBehaviourRuntimeError;

	/**
	 * register and execute this story
	 * @param story
	 * @param parsedStory
	 * @param registry
	 * @return
	 * @throws JBehaviourParsingError
	 * @throws JBehaviourRuntimeError
	 */
	public abstract boolean registerAndExecuteStory(String story,
			FormalStory parsedStory) throws JBehaviourParsingError,
			JBehaviourRuntimeError;

	/**
	 * execute this scenario
	 * @param registry
	 * @param scenario
	 * @return
	 * @throws JBehaviourRuntimeError
	 */
	public abstract boolean execute(KeywordScenario scenario)
			throws JBehaviourRuntimeError;

	/**
	 * get story
	 * @return
	 */
	FormalStory getParsedStory();

	/**
	 * execute on scenario
	 * @param scenario
	 * @return 
	 * @throws JBehaviourRuntimeError 
	 */
	public abstract boolean executeByStatement(String scenario) throws JBehaviourRuntimeError;
}