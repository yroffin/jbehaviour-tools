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
import org.jbehaviour.annotation.Call;
import org.jbehaviour.annotation.Then;
import org.jbehaviour.annotation.When;
import org.jbehaviour.exception.JBehaviourParsingError;
import org.jbehaviour.exception.JBehaviourRuntimeError;
import org.jbehaviour.parser.JBehaviourStatementParser;
import org.jbehaviour.parser.model.IKeywordStatement;
import org.jbehaviour.parser.model.IKeywordStatement.declareType;
import org.jbehaviour.parser.model.IKeywordStatement.statement;
import org.jbehaviour.reflexion.IBehaviourEnv;
import org.jbehaviour.reflexion.IBehaviourReflexion;
import org.jbehaviour.reflexion.IBehaviourReflexionBean;
import org.jbehaviour.reflexion.IBehaviourReflexionContext;
import org.jbehaviour.reflexion.IBehaviourReflexionMethodBean;
import org.jbehaviour.xref.IBehaviourXRef;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * implements the behaviour grabber
 */
public class JBehaviourReflexion implements IBehaviourReflexion {
	Logger logger = LoggerFactory.getLogger(JBehaviourReflexion.class);

	IBehaviourEnv env = null;
	Map<String, IBehaviourReflexionBean> beans = new HashMap<String, IBehaviourReflexionBean>();

	@Override
	public IBehaviourEnv setEnv(IBehaviourEnv _env) {
		env = _env;
		return env;
	}

	@Override
	public IBehaviourEnv getEnv() {
		return env;
	}

	public JBehaviourReflexion() throws JBehaviourParsingError {
	}

	private enum decode {
		Given, When, Then, Call
	}

	/**
	 * decode method type
	 * @param a
	 * @param method 
	 * @return
	 */
	private decode methodSelector(Annotation a, Method method) {
		decode swAnnotation = null;
		if (a.annotationType() == Given.class) {
			swAnnotation = decode.Given;
		}
		if (a.annotationType() == When.class) {
			swAnnotation = decode.When;
		}
		if (a.annotationType() == Then.class) {
			swAnnotation = decode.Then;
		}
		if (a.annotationType() == Call.class) {
			swAnnotation = decode.Call;
		}
		logger.info(swAnnotation.toString() + " method : " + method);
		return swAnnotation;
	}

	/**
	 * browse for method with annotation
	 * 
	 * @param myKlass
	 * @param bean
	 * @throws JBehaviourParsingError
	 */
	private void methodBrowsing(Class<?> myKlass, IBehaviourReflexionBean bean)
			throws JBehaviourParsingError {
		for (Method method : myKlass.getMethods()) {
			try {
				for (Annotation a : method.getAnnotations()) {
					switch (methodSelector(a, method)) {
					case Given:
						bean.addGiven((Given) a, method);
						break;
					case When:
						bean.addWhen((When) a, method);
						break;
					case Then:
						bean.addThen((Then) a, method);
						break;
					case Call:
						bean.addCall((Call) a, method);
						break;
					}
				}
			} catch (IOException e) {
				throw new JBehaviourParsingError(e);
			}
		}
	}

	public void register(String reference, String klass)
			throws JBehaviourParsingError {
		/**
		 * class loading
		 */
		Class<?> myKlass = null;
		try {
			myKlass = Class.forName(klass);
		} catch (ClassNotFoundException e) {
			throw new JBehaviourParsingError(e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("Class reflexion: " + klass + "/" + myKlass);
		}

		IBehaviourReflexionBean bean = new JBehaviourReflexionBean(klass,
				myKlass);
		beans.put(klass, bean);

		/**
		 * annotation browsing
		 */
		if (logger.isDebugEnabled()) {
			for (Annotation annotation : myKlass.getAnnotations()) {
				logger.debug("Class annotation: " + annotation);
			}
		}

		/**
		 * method browsing
		 */
		this.methodBrowsing(myKlass, bean);
	}

	/**
	 * find this context in registry
	 * 
	 * @param klass
	 * @param parsedStatement
	 * @param scenarioMethodName
	 * @param text
	 * @return
	 */
	private IBehaviourReflexionContext findInRegistry(statement klass,
			IKeywordStatement parsedStatement, String scenarioMethodName,
			String text) {
		IBehaviourReflexionContext search = null;

		for (String key : beans.keySet()) {
			IBehaviourReflexionBean bean = beans.get(key);
			/**
			 * call keywords
			 */
			if (klass == IKeywordStatement.statement.Call) {
				IBehaviourReflexionMethodBean method = bean
						.matchCall(parsedStatement);
				if (method != null) {
					search = new JBehaviourReflexionContext(scenarioMethodName,
							env, bean, method, parsedStatement, text);
				}
			}
			/**
			 * given keywords
			 */
			if (klass == IKeywordStatement.statement.Given) {
				IBehaviourReflexionMethodBean method = bean
						.matchGiven(parsedStatement);
				if (method != null) {
					search = new JBehaviourReflexionContext(scenarioMethodName,
							env, bean, method, parsedStatement, text);
				}
			}
			/**
			 * when keywords
			 */
			if (klass == IKeywordStatement.statement.When) {
				IBehaviourReflexionMethodBean method = bean
						.matchWhen(parsedStatement);
				if (method != null) {
					search = new JBehaviourReflexionContext(scenarioMethodName,
							env, bean, method, parsedStatement, text);
				}
			}
			/**
			 * then keywords
			 */
			if (klass == IKeywordStatement.statement.Then) {
				IBehaviourReflexionMethodBean method = bean
						.matchThen(parsedStatement);
				if (method != null) {
					search = new JBehaviourReflexionContext(scenarioMethodName,
							env, bean, method, parsedStatement, text);
				}
			}
		}
		return search;
	}

	@Override
	public IBehaviourReflexionContext retrieve(String scenarioMethodName,
			IKeywordStatement.statement klass, String text)
			throws JBehaviourParsingError, JBehaviourRuntimeError {
		/**
		 * first, parse this text then, find it in registry
		 */
		IKeywordStatement parsedStatement;
		parsedStatement = (new JBehaviourStatementParser(text)).parse();

		IBehaviourReflexionContext search = this.findInRegistry(klass,
				parsedStatement, scenarioMethodName, text);
		if (search == null) {
			logger.error("No match for this text: " + parsedStatement);
			throw new JBehaviourRuntimeError("No match for this text: "
					+ parsedStatement);
		} else {
			return search;
		}
	}

	/**
	 * declare a new String, Json reference
	 * 
	 * @param reference
	 * @param type
	 * @param statement
	 */
	public void declare(String reference, declareType type, String statement) {
		if (type == declareType.String) {
			env.store(reference, statement);
		}
		if (type == declareType.Json) {
			env.store(reference, statement);
		}
	}

	@Override
	public void declareString(String reference, String value) {
		env.store(reference, value);
	}

	@Override
	public void declareJson(String reference, String klass, String json)
			throws JBehaviourRuntimeError {
		env.store(reference, env.jsonToObject(klass, json));
	}

	@Override
	public IBehaviourXRef getXRef() {
		return env.getXRef();
	}
}
