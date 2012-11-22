package org.jbehaviour.parser.model.impl;

import org.jbehaviour.parser.model.IKeywordStatement;

public class KeywordStore extends KeywordStatement {
	public KeywordStore() {
		type = IKeywordStatement.statement.Store;
	}

	@Override
	public String toString() {
		return "KeywordStore [type=" + type + ", getStatement()="
				+ getStatement() + "]";
	}
}
