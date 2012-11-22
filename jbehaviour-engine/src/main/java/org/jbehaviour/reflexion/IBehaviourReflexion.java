package org.jbehaviour.reflexion;

import java.io.IOException;

import org.jbehaviour.exception.JBehaviourPasingError;
import org.jbehaviour.exception.JBehaviourRuntimeError;
import org.jbehaviour.parser.model.IKeywordStatement;

public interface IBehaviourReflexion {

	/**
	 * get env helper
	 * @return
	 */
	public IBehaviourEnv getEnv();

	/**
	 * register this new bean
	 * @param klass
	 * @param class1 
	 * @throws ClassNotFoundException
	 * @throws IOException 
	 * @throws JBehaviourPasingError 
	 */
	public abstract void register(String reference, String klass) throws JBehaviourPasingError;

	/**
	 * retrieve one method to invoke with its context
	 * @param text
	 * @return
	 * @throws IOException 
	 * @throws JBehaviourPasingError 
	 * @throws JBehaviourRuntimeError 
	 */
	public abstract IBehaviourReflexionContext retrieve(
			IKeywordStatement.statement klass, 
			String text) throws JBehaviourPasingError, JBehaviourRuntimeError;

	/**
	 * declare a string variable
	 * @param reference
	 * @param value
	 */
	public void declareString(String reference, String value);
	
	/**
	 * declare a json object
	 * @param reference
	 * @param klass
	 * @param json
	 * @throws JBehaviourRuntimeError 
	 */
	public void declareJson(String reference, String klass, String json) throws JBehaviourRuntimeError;
}