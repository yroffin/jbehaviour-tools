package org.jbehaviour.parser.model;

import org.jbehaviour.exception.JBehaviourPasingError;
import org.jbehaviour.parser.model.IKeywordStatement.declareType;

public interface IKeywordStatementElement {

	public abstract declareType getType();

	public abstract void setType(declareType type);

	public abstract String getValue();

	public abstract void setValue(String value);

	public boolean equals(IKeywordStatementElement iKeywordStatementElement);

	/**
	 * value manipulation
	 * @return
	 * @throws JBehaviourPasingError
	 */
	public abstract String extractLiteralAsString() throws JBehaviourPasingError;
	public String extractLiteralAsString(String value);
}