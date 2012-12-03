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

package org.jbehaviour.parser.model;

import java.util.List;

import org.jbehaviour.exception.JBehaviourParsingError;

public interface IKeywordStatement {

	public enum declareType {
		String,
		Reference,
		Identifier,
		Template,
		Json, Integer, None,
	}

	public enum statement {
		Feature,
		Scenario,
		Given,
		When,
		Then, 
		None,
		As,
		InOrder,
		I,
		Any,
		Register, 
		Store, 
		Declare,
		Include,
		Report
	}

	public void someWord(String value);
	public IKeywordStatementElement get(int i);
	public boolean compareTo(IKeywordStatement _parsedStatement);
	public int size();
	public List<IKeywordStatementElement> get();

	/**
	 * extract as litteral
	 * @param index
	 * @return
	 * @throws JBehaviourParsingError 
	 */
	public Integer extractLiteralAsInteger(int index) throws JBehaviourParsingError;
	public String  extractLiteralAsString(int index) throws JBehaviourParsingError;

	/**
	 * retrieve statements as a naming like a method
	 * @return
	 */
	public String getTextLikeMethod();
	
	/**
	 * retrieve statement as a string
	 * @return
	 */
	public String getStatement();
	
	/**
	 * retrieve type
	 * @return
	 */
	public statement getType();

	/**
	 * Register statement
	 * @throws JBehaviourParsingError 
	 */
	public String getReference() throws JBehaviourParsingError;
	public String getKlass() throws JBehaviourParsingError;

	/**
	 * Specific to Declare
	 * @param value
	 */
	public declareType getDeclareType();
	
	/**
	 * declaration
	 * @param value
	 */ 
	public void someString(String value);
	public void someIdentifier(String value);
	public void someReference(String value);
	public void someTemplate(String value);
	public void someInteger(String value);
	public void someJson(String value);
}
