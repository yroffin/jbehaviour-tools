package org.jbehaviour.reflexion;

import org.jbehaviour.exception.JBehaviourPasingError;
import org.jbehaviour.exception.JBehaviourRuntimeError;

public interface IBehaviourReflexionContext {
	Object execute() throws JBehaviourPasingError, JBehaviourRuntimeError;
}
