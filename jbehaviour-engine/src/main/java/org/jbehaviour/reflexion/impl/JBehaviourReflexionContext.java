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

import org.jbehaviour.exception.JBehaviourParsingError;
import org.jbehaviour.exception.JBehaviourRuntimeError;
import org.jbehaviour.parser.model.IKeywordStatement;
import org.jbehaviour.parser.model.IKeywordStatement.statement;
import org.jbehaviour.reflexion.IBehaviourEnv;
import org.jbehaviour.reflexion.IBehaviourReflexionBean;
import org.jbehaviour.reflexion.IBehaviourReflexionContext;
import org.jbehaviour.reflexion.IBehaviourReflexionMethodBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JBehaviourReflexionContext implements IBehaviourReflexionContext {
	Logger logger = LoggerFactory.getLogger(JBehaviourReflexionContext.class);

	@Override
	public String toString() {
		return "JBehaviourReflexionContext [logger=" + logger
				+ ", parsedStatement=" + parsedStatement + ", bean=" + bean
				+ ", method=" + method + ", scenarioMethodName="
				+ scenarioMethodName + "]";
	}

	private IKeywordStatement parsedStatement;
	private IBehaviourReflexionBean bean;
	private IBehaviourReflexionMethodBean method;
	private String scenarioMethodName;
	private String statement;

	@Override
	public String getStatement() {
		return statement;
	}

	public String getScenarioMethodName() {
		return scenarioMethodName;
	}

	/**
	 * build a new running context
	 * @param _scenarioMethodName 
	 * @param _env
	 * @param _bean
	 * @param _method
	 * @param _parsedStatement
	 * @param _text 
	 */
	public JBehaviourReflexionContext(
			String scenarioMethodName, 
			IBehaviourEnv env,
			IBehaviourReflexionBean bean,
			IBehaviourReflexionMethodBean method,
			IKeywordStatement parsedStatement, String text) {
		this.scenarioMethodName = scenarioMethodName;
		this.parsedStatement = parsedStatement;
		this.bean = bean;
		this.method = method;
		this.statement = text;
	}

	@Override
	public Object execute(IBehaviourEnv env) throws JBehaviourParsingError, JBehaviourRuntimeError {
		Object result;
		try {
			result = method.invoke(scenarioMethodName,env,bean.getInstance(env), parsedStatement);
		} catch (InstantiationException e) {
			return new JBehaviourRuntimeError(e);
		} catch (IllegalAccessException e) {
			return new JBehaviourRuntimeError(e);
		} catch (ClassNotFoundException e) {
			return new JBehaviourRuntimeError(e);
		}
		/**
		 * store on env last result
		 */
		env.store("result", result);
		logger.debug("Store result: " + env.getObject("result"));
		return result;
	}

	@Override
	public statement getType() {
		return method.getType();
	}
}
