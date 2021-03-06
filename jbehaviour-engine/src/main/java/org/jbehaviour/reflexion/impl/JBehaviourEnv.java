/**
 *  Copyright 2012 Yannick Roffin
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package org.jbehaviour.reflexion.impl;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.jbehaviour.IBehaviourLauncher;
import org.jbehaviour.annotation.EnvReference;
import org.jbehaviour.exception.JBehaviourParsingError;
import org.jbehaviour.exception.JBehaviourRuntimeError;
import org.jbehaviour.parser.JBehaviourCallParser;
import org.jbehaviour.parser.model.IKeywordStatement.statement;
import org.jbehaviour.parser.template.IKeywordCall;
import org.jbehaviour.reflexion.IBehaviourEnv;
import org.jbehaviour.reflexion.IBehaviourEnvProperty;
import org.jbehaviour.reflexion.IBehaviourReflexion;
import org.jbehaviour.reflexion.IBehaviourReflexionContext;
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

	private IBehaviourReflexion ref;

	private IBehaviourLauncher launcher;
	
	public JBehaviourEnv(IBehaviourLauncher _launcher, IBehaviourReflexion _registry, IBehaviourXRef _xref) {
		Velocity.init();
		context = new VelocityContext();
		xref = _xref;
		ref = _registry;
		ref.setEnv(this);
		launcher = _launcher;
	}

	@Override
	public List<IBehaviourEnvProperty> getProperties() {
		List<IBehaviourEnvProperty> properties = new ArrayList<IBehaviourEnvProperty>();
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
	public List<IBehaviourEnvProperty> getRawProperties() {
		List<IBehaviourEnvProperty> properties = new ArrayList<IBehaviourEnvProperty>();

		for(String key : registry.keySet()) {
			Object value = registry.get(key);
			if(value != null) {
				properties.add(new JBehaviourEnvProperty(key,value));
			} else {
				properties.add(new JBehaviourEnvProperty(key,null));
			}
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

	private static List<Field> getAllFields(List<Field> fields, Class<?> type) {
		for (Field field : type.getDeclaredFields()) {
			fields.add(field);
		}

		if (type.getSuperclass() != null) {
			fields = getAllFields(fields, type.getSuperclass());
		}

		return fields;
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
		for(Field field : getAllFields(new ArrayList<Field>(), myKlass)) {
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
	public String asString(String value) throws JBehaviourParsingError {
		writer = new StringWriter();
		Velocity.evaluate( context, writer, "", value);
		return writer.toString();
	}

	@Override
	public Object asObject(String value) throws JBehaviourParsingError {
		IKeywordCall call = (new JBehaviourCallParser(value)).parse();
		try {
			if(getObject(call.getIdentifier()) == null) {
				throw new JBehaviourParsingError("Reference is null");
			}
			return call.evaluate(getObject(call.getIdentifier()),0);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new JBehaviourParsingError(e);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw new JBehaviourParsingError(e);
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new JBehaviourParsingError(e);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			throw new JBehaviourParsingError(e);
		} catch (SecurityException e) {
			e.printStackTrace();
			throw new JBehaviourParsingError(e);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
			throw new JBehaviourParsingError(e);
		}
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

	@Override
	public IBehaviourReflexion getRef() {
		return ref;
	}

	@Override
	public IBehaviourLauncher getLauncher() {
		return launcher;
	}

	@Override
	public void register(String reference, String classname) throws JBehaviourParsingError {
		ref.register(reference, classname);
	}

	@Override
	public IBehaviourReflexionContext retrieve(String reference, statement s, String text) throws JBehaviourParsingError, JBehaviourRuntimeError {
		return ref.retrieve(reference, s, text);
	}
}
