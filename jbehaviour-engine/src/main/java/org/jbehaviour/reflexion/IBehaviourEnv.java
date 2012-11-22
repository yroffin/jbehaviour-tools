package org.jbehaviour.reflexion;

import java.io.IOException;

import org.jbehaviour.exception.JBehaviourPasingError;
import org.jbehaviour.exception.JBehaviourRuntimeError;

public interface IBehaviourEnv {
	public Object getObject(String id);

	public String getString(String id);

	public Object store(String id, Object value);

	public void store(String id, String value);

	String render(String value) throws IOException;

	Object getInstance(String key) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException, JBehaviourPasingError;

	Object jsonToObject(String klass, String value) throws JBehaviourRuntimeError;
}