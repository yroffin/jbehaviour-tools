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

package org.jbehaviour.reflexion;

import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;
import org.jbehaviour.IBehaviourLauncher;
import org.jbehaviour.exception.JBehaviourParsingError;
import org.jbehaviour.exception.JBehaviourRuntimeError;
import org.jbehaviour.parser.model.IKeywordStatement.statement;
import org.jbehaviour.xref.IBehaviourXRef;

/**
 * global repository of this system
 */
public interface IBehaviourEnv {
	/**
	 * public class to implement a custom
	 * property system
	 */
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
		public String getHtml() {
			return StringEscapeUtils.escapeHtml(value);
		}
	}
	/**
	 * read object from repository
	 * @param id
	 * @return
	 */
	public Object getObject(String id);
	/**
	 * get as string
	 * @param id
	 * @return
	 */
	public String getString(String id);
	/**
	 * store a new object with reference id
	 * @param id
	 * @param value
	 * @return
	 */
	public Object store(String id, Object value);
	/**
	 * store a new reference id, with value value
	 * @param id
	 * @param value
	 */
	public void store(String id, String value);
	/**
	 * get instance from key
	 */
	public Object getInstance(String key) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException, JBehaviourParsingError;
	/**
	 * object factory from json declaration
	 * @param klass
	 * @param value
	 * @return
	 * @throws JBehaviourRuntimeError
	 */
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
	/**
	 * read reference as string
	 * @param value
	 * @return
	 * @throws JBehaviourParsingError
	 */
	public Object asString(String value) throws JBehaviourParsingError;
	/**
	 * read reference as object
	 * @param value
	 * @return
	 * @throws JBehaviourParsingError
	 */
	public Object asObject(String value) throws JBehaviourParsingError;
	/**
	 * retrieve the launcher
	 * @return
	 */
	public IBehaviourLauncher getLauncher();
	/**
	 * retrieve the reflexion registry
	 * @return
	 */
	public IBehaviourReflexion getRef();
	/**
	 * regsiter a new class
	 * @param reference
	 * @param classname
	 * @throws JBehaviourParsingError 
	 */
	public void register(String reference, String classname) throws JBehaviourParsingError;
	/**
	 * retrieve a context to execute
	 * @param reference
	 * @param s
	 * @param text
	 * @return
	 * @throws JBehaviourRuntimeError 
	 * @throws JBehaviourParsingError 
	 */
	public IBehaviourReflexionContext retrieve(String reference, statement s, String text) throws JBehaviourParsingError, JBehaviourRuntimeError;
}