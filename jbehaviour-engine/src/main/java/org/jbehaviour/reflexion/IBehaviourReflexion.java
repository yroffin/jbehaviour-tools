package org.jbehaviour.reflexion;

import java.io.IOException;

import org.jbehaviour.exception.JBehaviourParsingError;
import org.jbehaviour.exception.JBehaviourRuntimeError;
import org.jbehaviour.parser.model.IKeywordStatement;
import org.jbehaviour.xref.IBehaviourXRef;

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
	 * @throws JBehaviourParsingError 
	 */
	public abstract void register(String reference, String klass) throws JBehaviourParsingError;

	/**
	 * retrieve one method to invoke with its context
	 * @param scenarioNameLikeMethod 
	 * @param text
	 * @return
	 * @throws IOException 
	 * @throws JBehaviourParsingError 
	 * @throws JBehaviourRuntimeError 
	 */
	public abstract IBehaviourReflexionContext retrieve(
			String scenarioNameLikeMethod, IKeywordStatement.statement klass, 
			String text) throws JBehaviourParsingError, JBehaviourRuntimeError;

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
	
	/**
	 * retrieve XRef
	 * @return
	 */
	public IBehaviourXRef getXRef();
}