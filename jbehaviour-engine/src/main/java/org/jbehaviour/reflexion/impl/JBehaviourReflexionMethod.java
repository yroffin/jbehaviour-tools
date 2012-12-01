package org.jbehaviour.reflexion.impl;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
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
import org.jbehaviour.parser.model.IKeywordStatement.statement;
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

	private statement type;

	@Override
	public statement getType() {
		return type;
	}

	/**
	 * analyze this method and prepare it
	 * @param type 
	 * @param _method
	 * @throws IOException
	 * @throws JBehaviourParsingError 
	 */
	private void parse(statement _type, String _text, Method _method) throws IOException, JBehaviourParsingError {
		type = _type;
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
		parse(IKeywordStatement.statement.Given, _annotation.value(), _method);
	}
	public JBehaviourReflexionMethod(When _annotation, Method _method) throws IOException, JBehaviourParsingError {
		parse(IKeywordStatement.statement.When, _annotation.value(),_method);
	}
	public JBehaviourReflexionMethod(Then _annotation, Method _method) throws IOException, JBehaviourParsingError {
		parse(IKeywordStatement.statement.Then, _annotation.value(),_method);
	}
	public JBehaviourReflexionMethod(Store _annotation, Method _method) throws IOException, JBehaviourParsingError {
		parse(IKeywordStatement.statement.Store, _annotation.value(),_method);
	}

	public boolean match(IKeywordStatement _parsedStatement) {
		return parsedStatement.compareTo(_parsedStatement);
	}
	private Object invokeLocaly(Object object, Object[] args) throws Exception {
		try {
			return methodToInvoke.invoke(object,args);
		} catch (IllegalAccessException e) {
			throw new JBehaviourRuntimeError(e);
		} catch (IllegalArgumentException e) {
			throw new JBehaviourRuntimeError(e);
		} catch (InvocationTargetException e) {
			throw new JBehaviourRuntimeError(e);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	/**
	 * class to catch all output
	 */
	private class SystemOut {
		private PrintStream stderr = null;
		private PrintStream stdout = null;
		private File ferr = null;
		private File fout = null;
		private PrintStream err = null;
		private PrintStream out = null;

		/**
		 * constructor
		 * @throws IOException
		 */
		public SystemOut() throws IOException {
			/**
			 * backup stream
			 */
			stdout = System.out;
			stderr = System.err;
			/**
			 * dump to file all stdout
			 */
			fout = File.createTempFile("outputStream", ".out");
			fout.deleteOnExit();
			logger.info("Output stdout to " + fout.getAbsolutePath());
			out = new PrintStream(fout);
			System.setOut(out);
			/**
			 * dump to file all stderr
			 */
			ferr = File.createTempFile("outputStream", ".err");
			ferr.deleteOnExit();
			logger.info("Output stderr to " + ferr.getAbsolutePath());
			err = new PrintStream(ferr);
			System.setErr(err);
		}
		
		/**
		 * restore output
		 */
		public void release() {
			System.setOut(stdout);
			System.setErr(stderr);
			err.close();
			out.close();
		}

		public File getFerr() {
			return ferr;
		}

		public File getFout() {
			return fout;
		}
	}
	public Object invoke(String pck, IBehaviourEnv env, Object object,IKeywordStatement parsedStatement) throws JBehaviourParsingError, JBehaviourRuntimeError {
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
					logger.debug("Lookup for " + name + " with " + parsedStatement.get(position).getValue());
					/**
					 * ignore first character : $, % ...
					 */
					args[index] = env.getObject(parsedStatement.get(position).getValue().substring(1));
					if(args[index] == null) {
						logger.warn("Lookup for " + name + " with id " + parsedStatement.get(position).getValue().substring(1) + " fail");
					} else {
						logger.info("$" + parsedStatement.get(position).getValue().substring(1) + " = " + args[index]);
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
		Object result = null;
		Exception excp = null;

		SystemOut output = null;

		try {
			try {
				output = new SystemOut();
				result = invokeLocaly(object,args);
			} catch(Exception e) {
				e.printStackTrace();
				logger.warn(e.getMessage());
				excp = e;
			}
		} finally {
			/**
			 * stop chrono
			 */
			env.getXRef().stop(
					pck,
					begin, 
					object.getClass().getPackage().getName(),
					methodToInvoke.getName(),
					object,args,
					text,
					output.getFout(),
					output.getFerr(),
					result,
					excp);
			output.release();
		}
		
		/**
		 * any exception must be thrown to
		 * the caller as an exception throw
		 */
		if(excp != null) {
			throw new JBehaviourRuntimeError(excp);
		}

		return result;
	}
}
