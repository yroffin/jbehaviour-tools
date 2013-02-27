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

package org.jbehaviour.parser.model.impl;

import org.jbehaviour.exception.JBehaviourParsingError;
import org.jbehaviour.parser.model.IKeywordStatementElement;
import org.jbehaviour.parser.model.IKeywordStatement.declareType;

class KeywordStatementElement implements IKeywordStatementElement {
	private declareType type;
	private String value;

	KeywordStatementElement(declareType type, String value) {
		setType(type);
		setValue(value);
	}

	@Override
	public declareType getType() {
		return type;
	}

	@Override
	public void setType(declareType type) {
		this.type = type;
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public boolean isLike(IKeywordStatementElement iKeywordStatementElement) {
		return iKeywordStatementElement.getValue().toLowerCase().compareTo(value.toLowerCase()) == 0;
	}

	@Override
	public String extractLiteralAsString() throws JBehaviourParsingError {
		if(getType() == org.jbehaviour.parser.model.IKeywordStatement.declareType.String) {
			return extractLiteralAsString(getValue());
		}
		throw new JBehaviourParsingError("Type is not valid: " + getType());
	}

	@Override
	public String extractLiteralAsString(String value) {
		if(value.charAt(0) == '\'' || value.charAt(0) == '"') {
			return value.substring(1,value.length()-1);
		} else return value;
	}

	@Override
	public String toString() {
		return "KeywordStatementElement [type=" + type + ", value=" + value
				+ "]";
	}

	@Override
	public String getCamelCaseValue() {
		return getValue().replace("$", "").toLowerCase();
	}
}
