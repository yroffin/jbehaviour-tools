package org.jbehaviour.parser.model.impl;

import org.jbehaviour.parser.model.IKeywordStatement;

public class KeywordWhen extends KeywordStatement {
	public KeywordWhen() {
		type = IKeywordStatement.statement.When;
	}

	@Override
	public String toString() {
		return "KeywordWhen [type=" + type + ", getStatement()="
				+ getStatement() + "]";
	}
}
