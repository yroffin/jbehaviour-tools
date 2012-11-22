package org.jbehaviour.parser.model.impl;

import org.jbehaviour.exception.JBehaviourPasingError;
import org.jbehaviour.parser.model.IKeywordStatement;

public class KeywordRegister extends KeywordStatement {

	public KeywordRegister() {
		type = IKeywordStatement.statement.Register;
	}

	@Override
	public String getReference() {
		return elements.get(0).getValue();
	}

	@Override
	public String getKlass() throws JBehaviourPasingError {
		return elements.get(2).extractLiteralAsString();
	}

	@Override
	public String toString() {
		return "Register [type=" + type + ", getStatement()="
				+ getStatement() + "]";
	}
}
