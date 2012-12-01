package org.jbehaviour.exception;

import java.io.IOException;

import org.antlr.runtime.RecognitionException;

public class JBehaviourParsingError extends Exception {

	/**
	 * default serial id
	 */
	private static final long serialVersionUID = 4322248954939295684L;

	public JBehaviourParsingError(String message) {
		super(message);
	}

	public JBehaviourParsingError(RecognitionException e) {
		super(e);
	}

	public JBehaviourParsingError(ClassNotFoundException e) {
		super(e);
	}

	public JBehaviourParsingError(IOException e) {
		super(e);
	}

	public JBehaviourParsingError(InstantiationException e) {
		super(e);
	}

	public JBehaviourParsingError(IllegalAccessException e) {
		super(e);
	}

}
