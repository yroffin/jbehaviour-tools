package org.jbehaviour.exception;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.antlr.runtime.RecognitionException;

public class JBehaviourRuntimeError extends Exception {

	/**
	 * default serial id
	 */
	private static final long serialVersionUID = 4322248954939295684L;

	public JBehaviourRuntimeError(String message) {
		super(message);
	}

	public JBehaviourRuntimeError(RecognitionException e) {
		super(e);
	}

	public JBehaviourRuntimeError(IOException e) {
		super(e);
	}

	public JBehaviourRuntimeError(InstantiationException e) {
		super(e);
	}

	public JBehaviourRuntimeError(IllegalAccessException e) {
		super(e);
	}

	public JBehaviourRuntimeError(ClassNotFoundException e) {
		super(e);
	}

	public JBehaviourRuntimeError(IllegalArgumentException e) {
		super(e);
	}

	public JBehaviourRuntimeError(InvocationTargetException e) {
		super(e);
	}

}
