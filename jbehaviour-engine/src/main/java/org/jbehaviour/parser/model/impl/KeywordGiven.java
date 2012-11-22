package org.jbehaviour.parser.model.impl;

import org.jbehaviour.parser.model.IKeywordStatement;

public class KeywordGiven extends KeywordStatement {

	public KeywordGiven() {
		type = IKeywordStatement.statement.Given;
	}

	@Override
	public String toString() {
		return "KeywordGiven [type=" + type + ", getStatement()="
				+ getStatement() + "]";
	}
}
