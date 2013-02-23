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

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.jbehaviour.annotation.Given;
import org.jbehaviour.annotation.Call;
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
	Map<String, Integer> parametersByName = new HashMap<String, Integer>();
	Map<Integer, String> parametersByOrder = new HashMap<Integer, String>();

	private String[] parameterNames;

	private statement type;

	@Override
	public statement getType() {
		return type;
	}

	/**
	 * analyze this method and prepare it
	 * 
	 * @param type
	 * @param _method
	 * @throws IOException
	 * @throws JBehaviourParsingError
	 */
	private void parse(statement _type, String _text, Method _method)
			throws IOException, JBehaviourParsingError {
		type = _type;
		methodToInvoke = _method;
		text = _text;
		/**
		 * parse the klass annotation value
		 */
		parsedStatement = (new JBehaviourStatementParser(text)).parse();
		int index = 0;
		for (IKeywordStatementElement item : parsedStatement.get()) {
			if (item.getType() == IKeywordStatement.declareType.Reference) {
				/**
				 * Suppression the variable indicator ($,% ...)
				 */
				String name = item.getValue()
						.subSequence(1, item.getValue().length()).toString();
				Integer position = new Integer(index++);
				parametersByName.put(name, position);
				parametersByOrder.put(position, name);
			} else {
				index++;
			}
		}
		/**
		 * option : use paranamer if configured if not, use raw order (as
		 * declared in annotation)
		 */
		Paranamer paranamer = new CachingParanamer();
		parameterNames = paranamer.lookupParameterNames(methodToInvoke, false);
		if (parameterNames == null || parameterNames.length == 0) {
			/**
			 * use default order stored in annotation
			 */
			parameterNames = new String[parametersByOrder.size()];
			index = 0;
			for (Integer parameter : parametersByOrder.keySet()) {
				parameterNames[index++] = parametersByOrder.get(parameter);
			}
		}
	}

	public JBehaviourReflexionMethod(Given _annotation, Method _method)
			throws IOException, JBehaviourParsingError {
		parse(IKeywordStatement.statement.Given, _annotation.value(), _method);
	}

	public JBehaviourReflexionMethod(When _annotation, Method _method)
			throws IOException, JBehaviourParsingError {
		parse(IKeywordStatement.statement.When, _annotation.value(), _method);
	}

	public JBehaviourReflexionMethod(Then _annotation, Method _method)
			throws IOException, JBehaviourParsingError {
		parse(IKeywordStatement.statement.Then, _annotation.value(), _method);
	}

	public JBehaviourReflexionMethod(Call _annotation, Method _method)
			throws IOException, JBehaviourParsingError {
		parse(IKeywordStatement.statement.Call, _annotation.value(), _method);
	}

	public boolean match(IKeywordStatement _parsedStatement) {
		return parsedStatement.compareTo(_parsedStatement);
	}

	private Object invokeLocaly(Object object, Object[] args) throws Exception {
		try {
			return methodToInvoke.invoke(object, args);
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
		 * 
		 * @throws IOException
		 */
		public SystemOut() throws IOException {
			/**
			 * backup stream
			 */
			stdout = System.out;
			stderr = System.err;

			/**
			 * create temporary files
			 */
			fout = File.createTempFile("outputStream", ".out");
			fout.deleteOnExit();
			ferr = File.createTempFile("outputStream", ".err");
			ferr.deleteOnExit();

			logger.info("Output stdout to " + fout.getAbsolutePath());
			logger.info("Output stderr to " + ferr.getAbsolutePath());

			/**
			 * unroute streams
			 */
			out = new PrintStream(fout);
			System.setOut(out);
			err = new PrintStream(ferr);
			System.setErr(err);
		}

		/**
		 * dump file to logger
		 * 
		 * @param prefix
		 * @param toDump
		 * @throws JBehaviourRuntimeError 
		 */
		private void dump(String prefix, File toDump) throws JBehaviourRuntimeError {
			try {
				// Open the file that is the first
				// command line parameter
				FileInputStream fstream = new FileInputStream(toDump);
				// Get the object of DataInputStream
				DataInputStream in = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(
						new InputStreamReader(in));
				String strLine;
				// Read File Line By Line
				while ((strLine = br.readLine()) != null) {
					logger.info(prefix + ":" + strLine);
				}
				// Close the input stream
				in.close();
			} catch (Exception e) {// Catch exception if any
				e.printStackTrace();
				throw new JBehaviourRuntimeError(e);
			}
		}

		/**
		 * restore output
		 * @throws JBehaviourRuntimeError 
		 */
		public void release() throws JBehaviourRuntimeError {
			System.setOut(stdout);
			System.setErr(stderr);
			err.close();
			out.close();

			/**
			 * dump stdout and stderr for this execution to logger
			 */
			dump("STDOUT",fout);
			dump("STDERR",ferr);
		}

		public File getFerr() {
			return ferr;
		}

		public File getFout() {
			return fout;
		}
	}

	public Object invoke(String pck, IBehaviourEnv env, Object object,
			IKeywordStatement parsedStatement) throws JBehaviourParsingError,
			JBehaviourRuntimeError {
		logger.info("Invoke with: " + methodToInvoke.getName() + " parsed: "
				+ parsedStatement);
		/**
		 * build parameters
		 */
		Object[] args = new Object[parametersByName.size()];
		int index = 0;
		/**
		 * iterate on parameterNames
		 */
		if(logger.isDebugEnabled()) logger.debug("parameterNames: " + parameterNames.length);
		for (String name : parameterNames) {
			if(logger.isDebugEnabled()) logger.debug("name: " + name);
			int position = parametersByName.get(name);

			switch (parsedStatement.get(position).getType()) {
			case Integer:
				if (methodToInvoke.getParameterTypes()[index] == Integer.class
						|| methodToInvoke.getParameterTypes()[index] == int.class) {
					/**
					 * Integer statement to Integer
					 */
					args[index] = parsedStatement
							.extractLiteralAsInteger(position);
				}
				break;
			case Identifier:
			case String:
				if (methodToInvoke.getParameterTypes()[index] == String.class) {
					/**
					 * String or identifier statement to String
					 */
					args[index] = parsedStatement
							.extractLiteralAsString(position);
				}
				break;
			case Reference:
				/**
				 * this reference is an object, we must find it in env
				 */
				logger.debug("Lookup for " + name + " with "
						+ parsedStatement.get(position).getValue());
				/**
				 * ignore first character : $, % ...
				 */
				args[index] = env.getObject(parsedStatement.get(position)
						.getValue().substring(1));
				if (args[index] == null) {
					logger.warn("Lookup for "
							+ name
							+ " with id "
							+ parsedStatement.get(position).getValue()
									.substring(1) + " fail");
				} else {
					logger.info("$"
							+ parsedStatement.get(position).getValue()
									.substring(1) + " = " + args[index]);
				}
				break;
			case Template:
				/**
				 * this template must be parsed
				 * - as velocity template if target type is String
				 * - as Object retrieve if target is not String
				 */
				logger.info("Templating for " + name + " with "
						+ parsedStatement.get(position).getValue() + " as " + methodToInvoke.getParameterTypes()[index]);
				try {
					Object rawValue = parsedStatement.get(position).getValue();
					Object asString = env.asString(parsedStatement.get(position).getValue());
					Object asObject = env.asObject(parsedStatement.get(position).getValue());
					if (rawValue.hashCode() == asObject.hashCode()) {
						args[index] = asString;
					} else {
						args[index] = asObject;
					}
				} catch (JBehaviourParsingError e) {
					throw new JBehaviourRuntimeError(e);
				}
				if (args[index] == null) {
					logger.warn("Templating for "
							+ name
							+ " with id "
							+ parsedStatement.get(position).getValue()
									.substring(1) + " fail");
				}
				break;
			case Json:
				/**
				 * this json string must be parsed
				 */
				logger.info("Json to object transformation for " + name
						+ " with " + parsedStatement.get(position).getValue());
				args[index] = env.jsonToObject(methodToInvoke
						.getParameterTypes()[index].getCanonicalName(),
						parsedStatement.get(position).getValue());
				if (args[index] == null) {
					logger.warn("Json to object transformation for "
							+ name
							+ " with id "
							+ parsedStatement.get(position).getValue()
									.substring(1) + " fail");
				}
				break;
			default:
				logger.warn("Unknown type "
						+ parsedStatement.get(position).getType() + " fail");
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
				result = invokeLocaly(object, args);
			} catch (Exception e) {
				e.printStackTrace();
				logger.warn(e.getMessage());
				excp = e;
			}
		} finally {
			/**
			 * stop chrono
			 */
			env.getXRef().stop(pck, begin,
					object.getClass().getPackage().getName(),
					methodToInvoke.getName(), object, args, text,
					output.getFout(), output.getFerr(), result, excp);
			output.release();
		}

		/**
		 * any exception must be thrown to the caller as an exception throw
		 */
		if (excp != null) {
			throw new JBehaviourRuntimeError(excp);
		}

		return result;
	}
}
