package org.jbehaviour.parser.model.impl;

import org.jbehaviour.parser.model.IKeywordStatement;

public class KeywordInOrder extends KeywordStatement {

	public KeywordInOrder() {
		type = IKeywordStatement.statement.InOrder;
	}

	@Override
	public String toString() {
		return "KeywordInOrder [type=" + type + ", getStatement()="
				+ getStatement() + "]";
	}
}
