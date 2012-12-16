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

import org.jbehaviour.exception.JBehaviourParsingError;
import org.jbehaviour.exception.JBehaviourRuntimeError;
import org.jbehaviour.parser.model.IKeywordStatement;

public interface IBehaviourReflexionContext {
	/**
	 * statement type
	 * @return
	 */
	IKeywordStatement.statement getType();
	
	/**
	 * execute this statement
	 * @return
	 * @throws JBehaviourParsingError
	 * @throws JBehaviourRuntimeError
	 */
	Object execute(IBehaviourEnv env) throws JBehaviourParsingError, JBehaviourRuntimeError;

	String getStatement();
}
