package org.jbehaviour.parser.model.impl;

import org.jbehaviour.exception.JBehaviourPasingError;
import org.jbehaviour.parser.model.IKeywordStatement;

public class KeywordInclude extends KeywordStatement {
	public KeywordInclude() {
		type = IKeywordStatement.statement.Include;
	}

	@Override
	public String getReference() throws JBehaviourPasingError {
		return elements.get(0).extractLiteralAsString();
	}

	@Override
	public String toString() {
		try {
			return "KeywordInclude [type=" + type + ", getReference()="
					+ getReference() + "]";
		} catch (JBehaviourPasingError e) {
			e.printStackTrace();
		}
		return null;
	}
}
