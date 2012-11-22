package org.jbehaviour.parser.model.impl;

import org.jbehaviour.parser.model.IKeywordStatement;

public class KeywordAny extends KeywordStatement {
	public KeywordAny() {
		type = IKeywordStatement.statement.Any;
	}

	@Override
	public String toString() {
		return "KeywordAny [type=" + type + ", getStatement()="
				+ getStatement() + "]";
	}
}
