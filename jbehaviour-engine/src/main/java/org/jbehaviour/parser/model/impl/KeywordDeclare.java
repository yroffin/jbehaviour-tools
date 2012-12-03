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

import org.jbehaviour.parser.model.IKeywordStatement;

public class KeywordDeclare extends KeywordStatement {
	public KeywordDeclare() {
		type = IKeywordStatement.statement.Declare;
	}

	@Override
	public String getReference() {
		return elements.get(0).getValue();
	}

	@Override
	public org.jbehaviour.parser.model.IKeywordStatement.declareType getDeclareType() {
		if("String".compareTo(elements.get(2).getValue())==0) {
			return org.jbehaviour.parser.model.IKeywordStatement.declareType.String;
		}
		if("Json".compareTo(elements.get(2).getValue())==0) {
			return org.jbehaviour.parser.model.IKeywordStatement.declareType.Json;
		}
		return org.jbehaviour.parser.model.IKeywordStatement.declareType.None;
	}

	@Override
	public String toString() {
		return "KeywordDeclare [type=" + type + ", getStatement()="
				+ getStatement() + "]";
	}
}
