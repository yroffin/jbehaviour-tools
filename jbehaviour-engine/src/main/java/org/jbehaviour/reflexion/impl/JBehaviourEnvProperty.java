package org.jbehaviour.reflexion.impl;

import org.apache.commons.lang.StringEscapeUtils;
import org.jbehaviour.reflexion.IBehaviourEnvProperty;

/**
 * public class to implement a custom property system
 */
public class JBehaviourEnvProperty implements IBehaviourEnvProperty {
	private String key;
	private Object value;

	public JBehaviourEnvProperty(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public JBehaviourEnvProperty(String key, Object value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public String getKey() {
		return key;
	}

	@Override
	public Object getValue() {
		return value;
	}

	@Override
	public String getHtml() {
		return StringEscapeUtils.escapeHtml((String) value);
	}

	@Override
	public String toString() {
		return "JBehaviourEnvProperty [key=" + key + ", value=" + value
				+ "]";
	}
}

