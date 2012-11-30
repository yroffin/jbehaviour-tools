package org.jbehaviour.reflexion;

import java.io.IOException;
import java.util.List;

import org.jbehaviour.exception.JBehaviourParsingError;
import org.jbehaviour.exception.JBehaviourRuntimeError;
import org.jbehaviour.xref.IBehaviourXRef;

public interface IBehaviourEnv {

	public class JBehaviourEnvProperty {
		private String key;
		private String value;
		public JBehaviourEnvProperty(String _key, String _value) {
			key = _key;
			value = _value;
		}
		public String getKey() {
			return key;
		}
		public String getValue() {
			return value;
		}
	}

	public Object getObject(String id);

	public String getString(String id);

	public Object store(String id, Object value);

	public void store(String id, String value);

	public String render(String value) throws IOException;

	public Object getInstance(String key) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException, JBehaviourParsingError;

	public Object jsonToObject(String klass, String value) throws JBehaviourRuntimeError;

	/**
	 * retrieve cross ref
	 * @return
	 */
	public IBehaviourXRef getXRef();

	/**
	 * retrieve all property of this system
	 * @return
	 */
	public List<JBehaviourEnvProperty> getProperties();
}