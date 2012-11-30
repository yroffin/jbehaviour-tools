package org.jbehaviour.parser.model.impl;

import org.jbehaviour.exception.JBehaviourParsingError;
import org.jbehaviour.parser.model.IKeywordStatement;

public class KeywordInclude extends KeywordStatement {
	public KeywordInclude() {
		type = IKeywordStatement.statement.Include;
	}

	@Override
	public String getReference() throws JBehaviourParsingError {
		return elements.get(0).extractLiteralAsString();
	}

	@Override
	public String toString() {
		try {
			return "KeywordInclude [type=" + type + ", getReference()="
					+ getReference() + "]";
		} catch (JBehaviourParsingError e) {
			e.printStackTrace();
		}
		return null;
	}
}
