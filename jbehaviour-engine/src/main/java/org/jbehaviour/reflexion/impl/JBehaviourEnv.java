package org.jbehaviour.reflexion.impl;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.jbehaviour.annotation.EnvReference;
import org.jbehaviour.exception.JBehaviourParsingError;
import org.jbehaviour.exception.JBehaviourRuntimeError;
import org.jbehaviour.reflexion.IBehaviourEnv;
import org.jbehaviour.xref.IBehaviourXRef;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JBehaviourEnv implements IBehaviourEnv {
	Logger logger = LoggerFactory.getLogger(JBehaviourEnv.class);

	private Map<String,Object> registry = new HashMap<String,Object>();
	private Map<String,Object> declare  = new HashMap<String,Object>();
	private VelocityContext context = null;
	private Writer writer = new StringWriter();

	private IBehaviourXRef xref;
	
	public JBehaviourEnv(IBehaviourXRef _xref) {
		Velocity.init();
		context = new VelocityContext();
		xref = _xref;
		
	}

	@Override
	public List<JBehaviourEnvProperty> getProperties() {
		List<JBehaviourEnvProperty> properties = new ArrayList<JBehaviourEnvProperty>();
		for(Entry<Object, Object> key : System.getProperties().entrySet()) {
			properties.add(
					new JBehaviourEnvProperty(
							key.getKey().toString(),
							key.getValue().toString().toString().replace("\"", "'")));
		}
		for(String key : registry.keySet()) {
			Object value = registry.get(key);
			if(value != null) {
				properties.add(new JBehaviourEnvProperty(key,value.toString().replace("\"", "'")));
			} else {
				properties.add(new JBehaviourEnvProperty(key,null));
			}
		}
		for(String key : declare.keySet()) {
			properties.add(new JBehaviourEnvProperty(key,declare.get(key).toString().replace("\"", "'")));
		}
		return properties;
	}

	@Override
	public Object getObject(String key) {
		return registry.get(key);
	}

	@Override
	public String getString(String key) {
		return (String) registry.get(key);
	}

	@Override
	public Object store(String key, Object value) {
		registry.put(key, value);
		/**
		 * update velocity context
		 */
		context.put(key, value);
		return value;
	}

	@Override
	public void store(String key, String value) {
		registry.put(key, value);
		/**
		 * update velocity context
		 */
		context.put(key, value);
	}

	@Override
	public Object getInstance(String key) throws InstantiationException, IllegalAccessException, ClassNotFoundException, JBehaviourParsingError {
		if(declare.containsKey(key)) {
			return declare.get(key);
		}
		Class<?> myKlass = Class.forName(key);
		
		declare.put(key,myKlass.newInstance());

		/**
		 * Env field injection
		 */
		for(Field field : myKlass.getDeclaredFields()) {
			for(Annotation a : field.getAnnotations()) {
				if(a.annotationType() == EnvReference.class) {
					logger.debug("Field env detected: " + field);
					if(field.getType() != IBehaviourEnv.class) {
						throw new JBehaviourParsingError("Bad annotation on field " + field.getName());
					}
					field.set(declare.get(key), this);
				}
			}
		}

		return declare.get(key);
	}

	@Override
	public String toString() {
		return "JBehaviourEnv [logger=" + logger + ", registry=" + registry
				+ ", declare=" + declare + "]";
	}

	@Override
	public String render(String value) throws IOException {
		writer = new StringWriter();
		Velocity.evaluate( context, writer, "", value);
		return writer.toString();
	}

	@Override
	public Object jsonToObject(String klass, String value) throws JBehaviourRuntimeError {
		try {
			return (new ObjectMapper()).readValue(value, Class.forName(klass));
		} catch (JsonParseException e) {
			throw new JBehaviourRuntimeError(e);
		} catch (JsonMappingException e) {
			throw new JBehaviourRuntimeError(e);
		} catch (ClassNotFoundException e) {
			throw new JBehaviourRuntimeError(e);
		} catch (IOException e) {
			throw new JBehaviourRuntimeError(e);
		}
	}

	@Override
	public IBehaviourXRef getXRef() {
		return xref;
	}
}
