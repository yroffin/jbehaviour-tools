package org.jbehaviour.parser.model.impl;

import org.jbehaviour.parser.model.IKeywordStatement;

public class KeywordAs extends KeywordStatement {

	public KeywordAs() {
		type = IKeywordStatement.statement.As;
	}

	@Override
	public String toString() {
		return "KeywordAs [type=" + type + ", getStatement()="
				+ getStatement() + "]";
	}
}
