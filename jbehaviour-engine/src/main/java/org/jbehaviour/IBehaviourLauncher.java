package org.jbehaviour;

import java.io.File;

import org.jbehaviour.exception.JBehaviourParsingError;
import org.jbehaviour.exception.JBehaviourRuntimeError;
import org.jbehaviour.parser.model.FormalStory;
import org.jbehaviour.parser.model.impl.KeywordScenario;
import org.jbehaviour.reflexion.IBehaviourEnv;

public interface IBehaviourLauncher {

	/**
	 * register and execute it
	 * @param story
	 * @return
	 * @throws JBehaviourParsingError
	 * @throws JBehaviourRuntimeError
	 */
	public abstract boolean registerAndExecute(File story)
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
	public abstract boolean registerAndExecuteStory(File story,
			FormalStory parsedStory) throws JBehaviourParsingError,
			JBehaviourRuntimeError;

	/**
	 * execute this scenario
	 * @param registry
	 * @param scenario
	 * @return
	 * @throws JBehaviourRuntimeError
	 */
	public abstract boolean execute(IBehaviourScenario scenario)
			throws JBehaviourRuntimeError;

	/**
	 * compile a parsed scenario
	 * @param parsedScenario
	 * @return
	 * @throws JBehaviourRuntimeError
	 */
	public IBehaviourScenario compile(KeywordScenario parsedScenario)
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

	IBehaviourEnv getEnv();
}