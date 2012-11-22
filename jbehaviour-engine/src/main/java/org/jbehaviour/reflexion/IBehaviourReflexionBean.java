package org.jbehaviour.reflexion;

import java.io.IOException;
import java.lang.reflect.Method;

import org.jbehaviour.annotation.Given;
import org.jbehaviour.annotation.Store;
import org.jbehaviour.annotation.Then;
import org.jbehaviour.annotation.When;
import org.jbehaviour.exception.JBehaviourPasingError;
import org.jbehaviour.parser.model.IKeywordStatement;

public interface IBehaviourReflexionBean {
	/**
	 * add a new given step
	 * @param annotation
	 * @param method
	 * @throws IOException 
	 * @throws JBehaviourPasingError 
	 */
	void addGiven(Given annotation, Method method) throws IOException, JBehaviourPasingError;
	/**
	 * add a new when step
	 * @param annotation
	 * @param method
	 * @throws IOException 
	 */
	void addWhen(When annotation, Method method) throws IOException, JBehaviourPasingError;
	/**
	 * add a new then step
	 * @param annotation
	 * @param method
	 * @throws IOException 
	 * @throws JBehaviourPasingError 
	 */
	void addThen(Then annotation, Method method) throws IOException, JBehaviourPasingError;
	/**
	 * a a new store method
	 * @param annotation
	 * @param method
	 * @throws IOException
	 * @throws JBehaviourPasingError
	 */
	void addStore(Store annotation, Method method) throws IOException, JBehaviourPasingError;
	/**
	 * is this statement match this text
	 * @param text
	 * @return
	 */
	IBehaviourReflexionMethodBean matchGiven(IKeywordStatement statement);
	/**
	 * is this statement match this text
	 * @param text
	 * @return
	 */
	IBehaviourReflexionMethodBean matchWhen(IKeywordStatement statement);
	/**
	 * is this statement match this text
	 * @param text
	 * @return
	 */
	IBehaviourReflexionMethodBean matchThen(IKeywordStatement statement);
	/**
	 * find bean which math this store statement
	 * @param parsedStatement
	 * @return
	 */
	IBehaviourReflexionMethodBean matchStore(IKeywordStatement parsedStatement);
	/**
	 * alocate a new instance for this object
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException 
	 * @throws JBehaviourPasingError 
	 */
	Object getInstance(IBehaviourEnv env) throws InstantiationException, IllegalAccessException, ClassNotFoundException, JBehaviourPasingError;
}
