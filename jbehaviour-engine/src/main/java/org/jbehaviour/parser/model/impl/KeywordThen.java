package org.jbehaviour.parser.model.impl;

import org.jbehaviour.parser.model.IKeywordStatement;

public class KeywordThen extends KeywordStatement {
	public KeywordThen() {
		type = IKeywordStatement.statement.Then;
	}

	@Override
	public String toString() {
		return "KeywordThen [type=" + type + ", getStatement()="
				+ getStatement() + "]";
	}
}
