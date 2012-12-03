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

import java.util.ArrayList;
import java.util.List;

import org.jbehaviour.exception.JBehaviourParsingError;
import org.jbehaviour.parser.model.IKeywordStatement;

public class KeywordScenario extends KeywordStatement {

	public KeywordScenario() {
		type = IKeywordStatement.statement.Scenario;
	}
	
	List<IKeywordStatement> keywordGivens = new ArrayList<IKeywordStatement>();
	List<IKeywordStatement> keywordWhens = new ArrayList<IKeywordStatement>();
	List<IKeywordStatement> keywordThens = new ArrayList<IKeywordStatement>();
	List<IKeywordStatement> keywordStores = new ArrayList<IKeywordStatement>();
	List<IKeywordStatement> keywords = new ArrayList<IKeywordStatement>();
	
	public List<IKeywordStatement> getKeywords() {
		return keywords;
	}

	public List<IKeywordStatement> getKeywordStores() {
		return keywordStores;
	}

	public List<IKeywordStatement> getKeywordGivens() {
		return keywordGivens;
	}


	public List<IKeywordStatement> getKeywordWhens() {
		return keywordWhens;
	}


	public List<IKeywordStatement> getKeywordThens() {
		return keywordThens;
	}

	@Override
	public String toString() {
		try {
			return "KeywordScenario [keywordGivens=" + keywordGivens
					+ ", keywordWhens=" + keywordWhens + ", keywordThens="
					+ keywordThens + ", keywordStores=" + keywordStores
					+ ", keywords=" + keywords + ", getStatement()="
					+ getStatement() + ", getReference()=" + getReference() + "]";
		} catch (JBehaviourParsingError e) {
			e.printStackTrace();
		}
		return null;
	}

	public IKeywordStatement addGivenStatement() {
		IKeywordStatement element = new KeywordGiven();
		keywordGivens.add(element);
		keywords.add(element);
		return element;
	}
	public IKeywordStatement addWhenStatement() {
		IKeywordStatement element = new KeywordWhen();
		keywordWhens.add(element);
		keywords.add(element);
		return element;
	}
	public IKeywordStatement addThenStatement() {
		IKeywordStatement element = new KeywordThen();
		keywordThens.add(element);
		keywords.add(element);
		return element;
	}
	public IKeywordStatement addStoreStatement() {
		IKeywordStatement element = new KeywordStore();
		keywordStores.add(element);
		keywords.add(element);
		return element;
	}
}
