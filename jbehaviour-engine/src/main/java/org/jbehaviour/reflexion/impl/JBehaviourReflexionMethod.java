package org.jbehaviour.reflexion.impl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.jbehaviour.annotation.Given;
import org.jbehaviour.annotation.Store;
import org.jbehaviour.annotation.Then;
import org.jbehaviour.annotation.When;
import org.jbehaviour.exception.JBehaviourParsingError;
import org.jbehaviour.exception.JBehaviourRuntimeError;
import org.jbehaviour.parser.JBehaviourStatementParser;
import org.jbehaviour.parser.model.IKeywordStatement;
import org.jbehaviour.parser.model.IKeywordStatementElement;
import org.jbehaviour.reflexion.IBehaviourEnv;
import org.jbehaviour.reflexion.IBehaviourReflexionMethodBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.paranamer.CachingParanamer;
import com.thoughtworks.paranamer.Paranamer;

public class JBehaviourReflexionMethod implements IBehaviourReflexionMethodBean {
	Logger logger = LoggerFactory.getLogger(JBehaviourReflexionMethod.class);

	/**
	 * method to invoke
	 */
	private Method methodToInvoke = null;
	/**
	 * original text (before parsing)
	 */
	private String text;
	IKeywordStatement parsedStatement;
	Map<String,Integer> parametersByName  = new HashMap<String,Integer>();
	Map<Integer,String> parametersByOrder = new HashMap<Integer,String>();

	private String[] parameterNames;

	/**
	 * analyze this method and prepare it
	 * @param _method
	 * @throws IOException
	 * @throws JBehaviourParsingError 
	 */
	private void parse(String _text, Method _method) throws IOException, JBehaviourParsingError {
		methodToInvoke = _method;
		text = _text;
		/**
		 * parse the klass annotation value
		 */
		parsedStatement = (new JBehaviourStatementParser(text)).parse();
		int index = 0;
		for(IKeywordStatementElement item : parsedStatement.get()) {
			if(item.getType() == IKeywordStatement.declareType.Reference) {
				/**
				 * Suppression the variable indicator ($,% ...)
				 */
				String name = item.getValue().subSequence(1, item.getValue().length()).toString();
				Integer position = new Integer(index++);
				parametersByName.put(name, position);
				parametersByOrder.put(position, name);
			} else {
				index++;
			}
		}
		/**
		 * option : use paranamer if configured
		 * if not, use raw order (as declared in annotation)
		 */
		Paranamer paranamer = new CachingParanamer();
		parameterNames = paranamer.lookupParameterNames(methodToInvoke, false);
		if(parameterNames.length == 0) {
			/**
			 * use default order stored
			 * in annotation
			 */
			parameterNames = new String[parametersByOrder.size()];
			index=0;
			for(Integer parameter : parametersByOrder.keySet()) {
				parameterNames[index++] = parametersByOrder.get(parameter);
			}
		}
	}

	public JBehaviourReflexionMethod(Given _annotation, Method _method) throws IOException, JBehaviourParsingError {
		parse(_annotation.value(),_method);
	}
	public JBehaviourReflexionMethod(When _annotation, Method _method) throws IOException, JBehaviourParsingError {
		parse(_annotation.value(),_method);
	}
	public JBehaviourReflexionMethod(Then _annotation, Method _method) throws IOException, JBehaviourParsingError {
		parse(_annotation.value(),_method);
	}
	public JBehaviourReflexionMethod(Store _annotation, Method _method) throws IOException, JBehaviourParsingError {
		parse(_annotation.value(),_method);
	}

	public boolean match(IKeywordStatement _parsedStatement) {
		return parsedStatement.compareTo(_parsedStatement);
	}
	private Object invokeLocaly(Object object, Object[] args) throws JBehaviourRuntimeError {
		try {
			return methodToInvoke.invoke(object,args);
		} catch (IllegalAccessException e) {
			throw new JBehaviourRuntimeError(e);
		} catch (IllegalArgumentException e) {
			throw new JBehaviourRuntimeError(e);
		} catch (InvocationTargetException e) {
			throw new JBehaviourRuntimeError(e);
		}
	}
	public Object invoke(IBehaviourEnv env, Object object,IKeywordStatement parsedStatement) throws JBehaviourParsingError, JBehaviourRuntimeError {
		logger.info("Invoke with: " + methodToInvoke.getName() + " parsed: " + parsedStatement);
		/**
		 * build parameters
		 */
		Object[] args = new Object[parametersByName.size()];
		int index=0;
		for(String name : parameterNames) {
			int position = parametersByName.get(name);
			
			switch(parsedStatement.get(position).getType()) {
				case Integer:
					if(methodToInvoke.getParameterTypes()[index] == Integer.class ||
					   methodToInvoke.getParameterTypes()[index] == int.class) {
						/**
						 * Integer statement to Integer
						 */
						args[index] = parsedStatement.extractLiteralAsInteger(position);
					}
					break;
				case Identifier:
				case String:
					if(methodToInvoke.getParameterTypes()[index] == String.class) {
						/**
						 * String or identifier statement to String
						 */
						args[index] = parsedStatement.extractLiteralAsString(position);
					}
					break;
				case Reference:
					/**
					 * this reference is an object, we must find it in env
					 */
					logger.info("Lookup for " + name + " with " + parsedStatement.get(position).getValue());
					/**
					 * ignore first character : $, % ...
					 */
					args[index] = env.getObject(parsedStatement.get(position).getValue().substring(1));
					if(args[index] == null) {
						logger.warn("Lookup for " + name + " with id " + parsedStatement.get(position).getValue().substring(1) + " fail");
					}
					break;
				case Template:
					/**
					 * this template must be parsed
					 */
					logger.info("Templating for " + name + " with " + parsedStatement.get(position).getValue());
					try {
						args[index] = env.render(parsedStatement.get(position).getValue());
					} catch (IOException e) {
						throw new JBehaviourRuntimeError(e);
					}
					if(args[index] == null) {
						logger.warn("Templating for " + name + " with id " + parsedStatement.get(position).getValue().substring(1) + " fail");
					}
					break;
				case Json:
					/**
					 * this json string must be parsed
					 */
					logger.info("Json to object transformation for " + name + " with " + parsedStatement.get(position).getValue());
					args[index] = env.jsonToObject(methodToInvoke.getParameterTypes()[index].getCanonicalName(),parsedStatement.get(position).getValue());
					if(args[index] == null) {
						logger.warn("Json to object transformation for " + name + " with id " + parsedStatement.get(position).getValue().substring(1) + " fail");
					}
					break;
				default:
					logger.warn("Unknown type " + parsedStatement.get(position).getType() + " fail");
					break;
			}
			index++;
		}
		
		/**
		 * start chrono
		 */
		Long begin = env.getXRef().start();
		Object result = invokeLocaly(object,args);
		/**
		 * stop chrono
		 */
		env.getXRef().stop(
				begin, 
				object.getClass().toString(),
				methodToInvoke.getName(),
				object,args,
				text);
		return result;
	}
}
