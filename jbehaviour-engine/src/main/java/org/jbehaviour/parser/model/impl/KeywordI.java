package org.jbehaviour.parser.model.impl;

import org.jbehaviour.parser.model.IKeywordStatement;

public class KeywordI extends KeywordStatement {

	public KeywordI() {
		type = IKeywordStatement.statement.I;
	}

	@Override
	public String toString() {
		return "KeywordI [type=" + type + ", getStatement()="
				+ getStatement() + "]";
	}
}
