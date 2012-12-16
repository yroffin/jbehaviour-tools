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
import java.lang.reflect.Method;

import org.jbehaviour.annotation.Call;
import org.jbehaviour.annotation.Given;
import org.jbehaviour.annotation.Then;
import org.jbehaviour.annotation.When;
import org.jbehaviour.exception.JBehaviourParsingError;
import org.jbehaviour.parser.model.IKeywordStatement;

public interface IBehaviourReflexionBean {
	/**
	 * add a new given step
	 * @param annotation
	 * @param method
	 * @throws IOException 
	 * @throws JBehaviourParsingError 
	 */
	void addGiven(Given annotation, Method method) throws IOException, JBehaviourParsingError;
	/**
	 * add a new when step
	 * @param annotation
	 * @param method
	 * @throws IOException 
	 */
	void addWhen(When annotation, Method method) throws IOException, JBehaviourParsingError;
	/**
	 * add a new then step
	 * @param annotation
	 * @param method
	 * @throws IOException 
	 * @throws JBehaviourParsingError 
	 */
	void addThen(Then annotation, Method method) throws IOException, JBehaviourParsingError;
	/**
	 * a a new store method
	 * @param annotation
	 * @param method
	 * @throws IOException
	 * @throws JBehaviourParsingError
	 */
	void addCall(Call annotation, Method method) throws IOException, JBehaviourParsingError;
	/**
	 * is this statement match this text
	 * @param text
	 * @return
	 */
	IBehaviourReflexionMethodBean matchGiven(IKeywordStatement statement);
	/**
	 * is this statement match this text
	 * @param text
	 * @return
	 */
	IBehaviourReflexionMethodBean matchWhen(IKeywordStatement statement);
	/**
	 * is this statement match this text
	 * @param text
	 * @return
	 */
	IBehaviourReflexionMethodBean matchThen(IKeywordStatement statement);
	/**
	 * find bean which math this call statement
	 * @param parsedStatement
	 * @return
	 */
	IBehaviourReflexionMethodBean matchCall(IKeywordStatement parsedStatement);
	/**
	 * alocate a new instance for this object
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException 
	 * @throws JBehaviourParsingError 
	 */
	Object getInstance(IBehaviourEnv env) throws InstantiationException, IllegalAccessException, ClassNotFoundException, JBehaviourParsingError;
}
