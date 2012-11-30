package org.jbehaviour.parser.model;

import org.jbehaviour.exception.JBehaviourParsingError;
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
	 * @throws JBehaviourParsingError
	 */
	public abstract String extractLiteralAsString() throws JBehaviourParsingError;
	public String extractLiteralAsString(String value);
}