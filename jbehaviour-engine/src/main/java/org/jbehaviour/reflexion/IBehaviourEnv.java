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

	public Object asString(String value) throws JBehaviourParsingError;
	public Object asObject(String value) throws JBehaviourParsingError;
}