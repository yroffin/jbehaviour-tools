package org.jbehaviour.reflexion;

import org.jbehaviour.exception.JBehaviourParsingError;
import org.jbehaviour.exception.JBehaviourRuntimeError;

public interface IBehaviourReflexionContext {
	Object execute() throws JBehaviourParsingError, JBehaviourRuntimeError;
}
