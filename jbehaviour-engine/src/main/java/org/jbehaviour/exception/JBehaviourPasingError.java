package org.jbehaviour.exception;

import java.io.IOException;

import org.antlr.runtime.RecognitionException;

public class JBehaviourPasingError extends Exception {

	/**
	 * default serial id
	 */
	private static final long serialVersionUID = 4322248954939295684L;

	public JBehaviourPasingError(String message) {
		super(message);
	}

	public JBehaviourPasingError(RecognitionException e) {
		super(e);
	}

	public JBehaviourPasingError(ClassNotFoundException e) {
		super(e);
	}

	public JBehaviourPasingError(IOException e) {
		super(e);
	}

}
