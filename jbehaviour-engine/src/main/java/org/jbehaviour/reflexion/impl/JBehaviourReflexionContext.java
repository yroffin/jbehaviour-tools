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

	private IKeywordStatement parsedStatement;
	private IBehaviourReflexionBean bean;
	private IBehaviourReflexionMethodBean method;
	private IBehaviourEnv env;
	private String scenarioMethodName;

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
	 */
	public JBehaviourReflexionContext(
			String _scenarioMethodName, 
			IBehaviourEnv _env,
			IBehaviourReflexionBean _bean,
			IBehaviourReflexionMethodBean _method,
			IKeywordStatement _parsedStatement) {
		scenarioMethodName = _scenarioMethodName;
		parsedStatement = _parsedStatement;
		bean = _bean;
		method = _method;
		env = _env;
	}

	public Object execute() throws JBehaviourParsingError, JBehaviourRuntimeError {
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
		logger.info("Store result: " + env.getObject("result"));
		return result;
	}

	@Override
	public statement getType() {
		return method.getType();
	}
}
