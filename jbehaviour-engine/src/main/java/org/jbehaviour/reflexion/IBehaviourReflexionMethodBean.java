package org.jbehaviour.reflexion;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.jbehaviour.exception.JBehaviourPasingError;
import org.jbehaviour.exception.JBehaviourRuntimeError;
import org.jbehaviour.parser.model.IKeywordStatement;

public interface IBehaviourReflexionMethodBean {
	public boolean match(IKeywordStatement parsedStatement);
	/**
	 * invoke this method, with object given in argument
	 * @param object
	 * @param object 
	 * @param parsedStatement
	 * @return 
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws JBehaviourPasingError 
	 * @throws IOException 
	 */
	public Object invoke(IBehaviourEnv env, Object object, IKeywordStatement parsedStatement) throws JBehaviourPasingError, JBehaviourRuntimeError;
}
