package org.jbehaviour.reflexion.impl;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.jbehaviour.annotation.Given;
import org.jbehaviour.annotation.Store;
import org.jbehaviour.annotation.Then;
import org.jbehaviour.annotation.When;
import org.jbehaviour.exception.JBehaviourPasingError;
import org.jbehaviour.exception.JBehaviourRuntimeError;
import org.jbehaviour.parser.JBehaviourStatementParser;
import org.jbehaviour.parser.model.IKeywordStatement;
import org.jbehaviour.parser.model.IKeywordStatement.declareType;
import org.jbehaviour.reflexion.IBehaviourEnv;
import org.jbehaviour.reflexion.IBehaviourReflexion;
import org.jbehaviour.reflexion.IBehaviourReflexionBean;
import org.jbehaviour.reflexion.IBehaviourReflexionContext;
import org.jbehaviour.reflexion.IBehaviourReflexionMethodBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * implements the behaviour grabber
 */
public class JBehaviourReflexion implements IBehaviourReflexion {
	Logger logger = LoggerFactory.getLogger(JBehaviourReflexion.class);

	IBehaviourEnv env = new JBehaviourEnv();
	Map<String,IBehaviourReflexionBean> beans = new HashMap<String,IBehaviourReflexionBean>();

	public IBehaviourEnv getEnv() {
		return env;
	}

	public JBehaviourReflexion() throws JBehaviourPasingError {
		/**
		 * default object to handle
		 * store system
		 */
		register("storeBean","org.jbehaviour.plugins.StoreSteps");
	}

	public void register(String reference, String klass) throws JBehaviourPasingError {
		Class<?> myKlass = null;
		try {
			myKlass = Class.forName(klass);
		} catch (ClassNotFoundException e) {
			throw new JBehaviourPasingError(e);
		}
		logger.debug("Class reflexion: " + klass + "/" + myKlass);

		IBehaviourReflexionBean bean = new JBehaviourReflexionBean(klass,myKlass);
		beans.put(klass, bean);

		/**
		 * annotation browsing
		 */
		for(Annotation annotation : myKlass.getAnnotations()) {
			logger.debug("Class annotation: " + annotation);
		}
		/**
		 * method browsing
		 */
		for(Method method : myKlass.getMethods()) {
			for(Annotation a : method.getAnnotations()) {
				if(a.annotationType() == Given.class) {
					logger.debug("Class method: " + method);
					try {
						bean.addGiven((Given)a,method);
					} catch (IOException e) {
						throw new JBehaviourPasingError(e);
					}
				}
				if(a.annotationType() == When.class) {
					logger.debug("Class method: " + method);
					try {
						bean.addWhen((When)a,method);
					} catch (IOException e) {
						throw new JBehaviourPasingError(e);
					}
				}
				if(a.annotationType() == Then.class) {
					logger.debug("Class method: " + method);
					try {
						bean.addThen((Then)a,method);
					} catch (IOException e) {
						throw new JBehaviourPasingError(e);
					}
				}
				if(a.annotationType() == Store.class) {
					logger.debug("Class method: " + method);
					try {
						bean.addStore((Store)a,method);
					} catch (IOException e) {
						throw new JBehaviourPasingError(e);
					}
				}
			}
		}
	}

	public IBehaviourReflexionContext retrieve(IKeywordStatement.statement klass, String text) throws JBehaviourPasingError, JBehaviourRuntimeError {
		/**
		 * first, parse this text
		 */
		IKeywordStatement parsedStatement;
		parsedStatement = (new JBehaviourStatementParser(text)).parse();
		IBehaviourReflexionContext search = null;
	
		/**
		 * then, find it in registry
		 */
		for(String key : beans.keySet()) {
			IBehaviourReflexionBean bean = beans.get(key);
			/**
			 * store keywords
			 */
			if(klass == IKeywordStatement.statement.Store) {
				IBehaviourReflexionMethodBean method = bean.matchStore(parsedStatement);
				if(method != null) {
					search = new JBehaviourReflexionContext(env,bean,method,parsedStatement);
				}
			}
			/**
			 * given keywords
			 */
			if(klass == IKeywordStatement.statement.Given) {
				IBehaviourReflexionMethodBean method = bean.matchGiven(parsedStatement);
				if(method != null) {
					search = new JBehaviourReflexionContext(env,bean,method,parsedStatement);
				}
			}
			/**
			 * when keywords
			 */
			if(klass == IKeywordStatement.statement.When) {
				IBehaviourReflexionMethodBean method = bean.matchWhen(parsedStatement);
				if(method != null) {
					search = new JBehaviourReflexionContext(env,bean,method,parsedStatement);
				}
			}
			/**
			 * then keywords
			 */
			if(klass == IKeywordStatement.statement.Then) {
				IBehaviourReflexionMethodBean method = bean.matchThen(parsedStatement);
				if(method != null) {
					search = new JBehaviourReflexionContext(env,bean,method,parsedStatement);
				}
			}
		}
		
		if(search == null) {
			logger.error("No match for this text: " + parsedStatement);
			throw new JBehaviourRuntimeError("No match for this text: " + parsedStatement);
		} else {
			return search;
		}
	}

	public void declare(String reference, declareType type, String statement) {
		if(type == declareType.String) {
			env.store(reference, statement);		
		}
		if(type == declareType.Json) {
			env.store(reference, statement);		
		}
	}

	@Override
	public void declareString(String reference, String value) {
		env.store(reference, value);		
	}

	@Override
	public void declareJson(String reference, String klass, String json) throws JBehaviourRuntimeError {
		env.store(reference, env.jsonToObject(klass, json));
	}
}
