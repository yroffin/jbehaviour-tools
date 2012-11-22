package org.jbehaviour.parser;

import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.jbehaviour.antlr.AnotherStoryGrammerLexer;
import org.jbehaviour.exception.JBehaviourPasingError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JBehahiourLexer extends AnotherStoryGrammerLexer {
	Logger logger = LoggerFactory.getLogger(JBehahiourLexer.class);

	int error = 0;
	
	public int getError() {
		return error;
	}

	public JBehahiourLexer(ANTLRFileStream antlrFileStream) {
		super(antlrFileStream);
	}

	public JBehahiourLexer(ANTLRStringStream antlrStringStream) {
		super(antlrStringStream);
	}

	@Override
	public void emitErrorMessage(String msg) {
		logger.error(msg);
		error++;
	}

	protected static CommonTokenStream getTokens(String filename) throws JBehaviourPasingError {
		JBehahiourLexer lexer;
		try {
			lexer = new JBehahiourLexer(
					new ANTLRFileStream(filename,"UTF8"));
		} catch (IOException e) {
			throw new JBehaviourPasingError(e);
		}
		return new CommonTokenStream(lexer);
	}
	
	protected static CommonTokenStream getTokensFromString(String data) throws JBehaviourPasingError {
		JBehahiourLexer lexer = new JBehahiourLexer(new ANTLRStringStream(data));
		return new CommonTokenStream(lexer);
	}

	public void setError(int i) {
		error = i;		
	}

}
