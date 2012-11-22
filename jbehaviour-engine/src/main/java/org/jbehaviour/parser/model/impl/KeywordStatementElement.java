package org.jbehaviour.parser.model.impl;

import org.jbehaviour.exception.JBehaviourPasingError;
import org.jbehaviour.parser.model.IKeywordStatementElement;
import org.jbehaviour.parser.model.IKeywordStatement.declareType;

class KeywordStatementElement implements IKeywordStatementElement {
	declareType type;
	String value;

	KeywordStatementElement(declareType type, String value) {
		setType(type);
		setValue(value);
	}

	/* (non-Javadoc)
	 * @see org.jbehaviour.parser.model.IKeywordStatementElement#getType()
	 */
	@Override
	public declareType getType() {
		return type;
	}

	/* (non-Javadoc)
	 * @see org.jbehaviour.parser.model.IKeywordStatementElement#setType(org.jbehaviour.parser.model.IKeywordStatement.declareType)
	 */
	@Override
	public void setType(declareType type) {
		this.type = type;
	}

	/* (non-Javadoc)
	 * @see org.jbehaviour.parser.model.IKeywordStatementElement#getValue()
	 */
	@Override
	public String getValue() {
		return value;
	}

	/* (non-Javadoc)
	 * @see org.jbehaviour.parser.model.IKeywordStatementElement#setValue(java.lang.String)
	 */
	@Override
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public boolean equals(IKeywordStatementElement iKeywordStatementElement) {
		return iKeywordStatementElement.getValue().toLowerCase().compareTo(value.toLowerCase()) == 0;
	}

	@Override
	public String extractLiteralAsString() throws JBehaviourPasingError {
		if(getType() == org.jbehaviour.parser.model.IKeywordStatement.declareType.String) {
			return extractLiteralAsString(getValue());
		}
		throw new JBehaviourPasingError("Type is not valid: " + getType());
	}

	@Override
	public String extractLiteralAsString(String value) {
		if(value.charAt(0) == '\'' || value.charAt(0) == '"') {
			return value.substring(1,value.length()-1);
		} else return value;
	}

	@Override
	public String toString() {
		return "KeywordStatementElement [type=" + type + ", value=" + value
				+ "]";
	}
}
