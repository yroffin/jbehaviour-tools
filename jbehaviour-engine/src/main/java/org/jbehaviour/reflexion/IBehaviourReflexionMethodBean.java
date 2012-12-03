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

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.jbehaviour.exception.JBehaviourParsingError;
import org.jbehaviour.exception.JBehaviourRuntimeError;
import org.jbehaviour.parser.model.IKeywordStatement;
import org.jbehaviour.parser.model.IKeywordStatement.statement;

public interface IBehaviourReflexionMethodBean {
	public boolean match(IKeywordStatement parsedStatement);
	/**
	 * invoke this method, with object given in argument
	 * @param scenarioMethodName 
	 * @param object
	 * @param object 
	 * @param parsedStatement
	 * @return 
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws JBehaviourParsingError 
	 * @throws IOException 
	 */
	public Object invoke(String scenarioMethodName, IBehaviourEnv env, Object object, IKeywordStatement parsedStatement) throws JBehaviourParsingError, JBehaviourRuntimeError;
	statement getType();
}
