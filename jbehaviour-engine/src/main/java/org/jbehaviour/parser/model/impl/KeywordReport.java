package org.jbehaviour.parser.model.impl;

import org.jbehaviour.exception.JBehaviourParsingError;
import org.jbehaviour.parser.model.IKeywordStatement;

public class KeywordReport extends KeywordStatement {
	public KeywordReport() {
		type = IKeywordStatement.statement.Report;
	}

	@Override
	public String getKlass() throws JBehaviourParsingError {
		return elements.get(0).extractLiteralAsString();
	}

	public String getTemplate() throws JBehaviourParsingError {
		return elements.get(1).extractLiteralAsString();
	}

	public String getOutputFile() throws JBehaviourParsingError {
		return elements.get(2).extractLiteralAsString();
	}

	@Override
	public String toString() {
		return "KeywordReport [type=" + type + ", getStatement()="
				+ getStatement() + "]";
	}
}
