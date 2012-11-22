package org.jbehaviour.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.antlr.runtime.RecognitionException;
import org.jbehaviour.antlr.AnotherStoryGrammerParser;
import org.jbehaviour.exception.JBehaviourPasingError;
import org.jbehaviour.parser.model.IKeywordStatement;
import org.jbehaviour.parser.model.impl.KeywordAny;

public class JBehaviourStatementParser extends AnotherStoryGrammerParser {
	Logger logger = LoggerFactory.getLogger(JBehaviourStatementParser.class);

	JBehahiourLexer lexer;
	
	public JBehaviourStatementParser(String data) throws JBehaviourPasingError {
		super(JBehahiourLexer.getTokensFromString(data));
		lexer = (JBehahiourLexer) input.getTokenSource();
	}

	int error = 0;
	@Override
	public void emitErrorMessage(String msg) {
		logger.error(msg);
		error++;
	}

	private IKeywordStatement current = new KeywordAny();

	@Override
	public void onAnyNumeric(String value) {
		super.onAnyNumeric(value);
		if(current != null) {
			logger.debug("on "+current.getType()+" any integer: " + value);
			current.someInteger(value);
		} else {
			logger.error("Internal error");
		}
	}

	@Override
	public void onAnyString(String value) {
		super.onAnyString(value);
		logger.debug("on scenario/any string: " + value);
		current.someString(value);
	}

	@Override
	public void onAnyIdentifier(String value) {
		super.onAnyIdentifier(value);
		logger.debug("on scenario/any identifier: " + value);
		current.someIdentifier(value);
	}

	@Override
	public void onAnyReference(String value) {
		super.onAnyReference(value);
		logger.debug("on scenario/any reference: " + value);
		current.someReference(value);
	}

	@Override
	public void onAnyTemplate(String value) {
		super.onAnyTemplate(value);
		logger.debug("on scenario/any template: " + value);
		current.someTemplate(value);
	}

	@Override
	public void onAnyJsonObject(String value) {
		super.onAnyJsonObject(value);
		if(current != null) {
			logger.debug("on "+current.getType()+" any json: " + value);
			current.someJson(value);
		} else {
			logger.error("Internal error");
		}
	}

	public IKeywordStatement parse() throws JBehaviourPasingError {
		try {
			error = 0;
			lexer.setError(0);
			anyDecl();
			if(lexer.getError()>0) throw new JBehaviourPasingError("This story has lexer errors");
			if(error>0) throw new JBehaviourPasingError("This statement has errors");
			return current;
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		return null;
	}
}
