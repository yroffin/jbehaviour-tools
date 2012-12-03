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
import org.jbehaviour.exception.JBehaviourParsingError;
import org.jbehaviour.exception.JBehaviourRuntimeError;
import org.jbehaviour.parser.JBehaviourStatementParser;
import org.jbehaviour.parser.model.IKeywordStatement;
import org.jbehaviour.parser.model.IKeywordStatement.declareType;
import org.jbehaviour.reflexion.IBehaviourEnv;
import org.jbehaviour.reflexion.IBehaviourReflexion;
import org.jbehaviour.reflexion.IBehaviourReflexionBean;
import org.jbehaviour.reflexion.IBehaviourReflexionContext;
import org.jbehaviour.reflexion.IBehaviourReflexionMethodBean;
import org.jbehaviour.xref.IBehaviourXRef;
import org.jbehaviour.xref.impl.JBehaviourXRef;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * implements the behaviour grabber
 */
public class JBehaviourReflexion implements IBehaviourReflexion {
	Logger logger = LoggerFactory.getLogger(JBehaviourReflexion.class);

	IBehaviourEnv env = new JBehaviourEnv(new JBehaviourXRef());
	Map<String,IBehaviourReflexionBean> beans = new HashMap<String,IBehaviourReflexionBean>();

	public IBehaviourEnv getEnv() {
		return env;
	}

	public JBehaviourReflexion() throws JBehaviourParsingError {
	}

	public void register(String reference, String klass) throws JBehaviourParsingError {
		Class<?> myKlass = null;
		try {
			myKlass = Class.forName(klass);
		} catch (ClassNotFoundException e) {
			throw new JBehaviourParsingError(e);
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
						throw new JBehaviourParsingError(e);
					}
				}
				if(a.annotationType() == When.class) {
					logger.debug("Class method: " + method);
					try {
						bean.addWhen((When)a,method);
					} catch (IOException e) {
						throw new JBehaviourParsingError(e);
					}
				}
				if(a.annotationType() == Then.class) {
					logger.debug("Class method: " + method);
					try {
						bean.addThen((Then)a,method);
					} catch (IOException e) {
						throw new JBehaviourParsingError(e);
					}
				}
				if(a.annotationType() == Store.class) {
					logger.debug("Class method: " + method);
					try {
						bean.addStore((Store)a,method);
					} catch (IOException e) {
						throw new JBehaviourParsingError(e);
					}
				}
			}
		}
	}

	public IBehaviourReflexionContext retrieve(String scenarioMethodName, IKeywordStatement.statement klass, String text) throws JBehaviourParsingError, JBehaviourRuntimeError {
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
					search = new JBehaviourReflexionContext(scenarioMethodName, env, bean, method, parsedStatement);
				}
			}
			/**
			 * given keywords
			 */
			if(klass == IKeywordStatement.statement.Given) {
				IBehaviourReflexionMethodBean method = bean.matchGiven(parsedStatement);
				if(method != null) {
					search = new JBehaviourReflexionContext(scenarioMethodName, env, bean, method, parsedStatement);
				}
			}
			/**
			 * when keywords
			 */
			if(klass == IKeywordStatement.statement.When) {
				IBehaviourReflexionMethodBean method = bean.matchWhen(parsedStatement);
				if(method != null) {
					search = new JBehaviourReflexionContext(scenarioMethodName, env,bean,method,parsedStatement);
				}
			}
			/**
			 * then keywords
			 */
			if(klass == IKeywordStatement.statement.Then) {
				IBehaviourReflexionMethodBean method = bean.matchThen(parsedStatement);
				if(method != null) {
					search = new JBehaviourReflexionContext(scenarioMethodName, env, bean, method, parsedStatement);
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

	@Override
	public IBehaviourXRef getXRef() {
		return env.getXRef();
	}
}
