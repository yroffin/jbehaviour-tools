package org.jbehaviour.parser.model.impl;

import org.jbehaviour.parser.model.IKeywordStatement;

public class KeywordDeclare extends KeywordStatement {
	public KeywordDeclare() {
		type = IKeywordStatement.statement.Declare;
	}

	@Override
	public String getReference() {
		return elements.get(0).getValue();
	}

	@Override
	public org.jbehaviour.parser.model.IKeywordStatement.declareType getDeclareType() {
		if("String".compareTo(elements.get(2).getValue())==0) {
			return org.jbehaviour.parser.model.IKeywordStatement.declareType.String;
		}
		if("Json".compareTo(elements.get(2).getValue())==0) {
			return org.jbehaviour.parser.model.IKeywordStatement.declareType.Json;
		}
		return org.jbehaviour.parser.model.IKeywordStatement.declareType.None;
	}

	@Override
	public String toString() {
		return "KeywordDeclare [type=" + type + ", getStatement()="
				+ getStatement() + "]";
	}
}
