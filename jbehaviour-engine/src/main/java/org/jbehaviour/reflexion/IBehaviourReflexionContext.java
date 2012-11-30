package org.jbehaviour.reflexion;

import org.jbehaviour.exception.JBehaviourParsingError;
import org.jbehaviour.exception.JBehaviourRuntimeError;
import org.jbehaviour.parser.model.IKeywordStatement;

public interface IBehaviourReflexionContext {
	/**
	 * statement type
	 * @return
	 */
	IKeywordStatement.statement getType();
	
	/**
	 * execute this statement
	 * @return
	 * @throws JBehaviourParsingError
	 * @throws JBehaviourRuntimeError
	 */
	Object execute() throws JBehaviourParsingError, JBehaviourRuntimeError;
}
