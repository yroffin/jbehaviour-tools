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

import org.jbehaviour.exception.JBehaviourParsingError;
import org.jbehaviour.parser.model.IKeywordStatement.declareType;

public interface IKeywordStatementElement {

	public abstract declareType getType();

	public abstract void setType(declareType type);

	public abstract String getValue();

	public abstract void setValue(String value);

	public boolean equals(IKeywordStatementElement iKeywordStatementElement);

	/**
	 * value manipulation
	 * @return
	 * @throws JBehaviourParsingError
	 */
	public abstract String extractLiteralAsString() throws JBehaviourParsingError;
	public String extractLiteralAsString(String value);

	/**
	 * retrieve a value in camel case mode
	 * @return
	 */
	public abstract String getCamelCaseValue();
}