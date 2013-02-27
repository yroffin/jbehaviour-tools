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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KeywordFeature extends KeywordStatement {
	private static Logger logger = LoggerFactory.getLogger(KeywordFeature.class);

	public KeywordFeature() {
		type = IKeywordStatement.statement.Feature;
	}

	List<IKeywordStatement> keywordInOrders = new ArrayList<IKeywordStatement>();
	List<IKeywordStatement> keywordAss = new ArrayList<IKeywordStatement>();
	List<IKeywordStatement> keywordIs = new ArrayList<IKeywordStatement>();
	List<IKeywordStatement> keywordRegisters = new ArrayList<IKeywordStatement>();
	List<IKeywordStatement> keywordReports = new ArrayList<IKeywordStatement>();
	List<IKeywordStatement> keywordDeclares = new ArrayList<IKeywordStatement>();
	List<IKeywordStatement> keywordIncludes = new ArrayList<IKeywordStatement>();
	
	public List<IKeywordStatement> getKeywordInclude() {
		return keywordIncludes;
	}

	public List<IKeywordStatement> getKeywordReports() {
		return keywordReports;
	}

	public List<IKeywordStatement> getKeywordInOrders() {
		return keywordInOrders;
	}

	public List<IKeywordStatement> getKeywordAsSomeone() {
		return keywordAss;
	}


	public List<IKeywordStatement> getKeywordIs() {
		return keywordIs;
	}

	public List<IKeywordStatement> getKeywordRegister() {
		return keywordRegisters;
	}

	public List<IKeywordStatement> getKeywordDeclare() {
		return keywordDeclares;
	}

	@Override
	public String toString() {
		return "KeywordFeature [keywordInOrders=" + keywordInOrders
				+ ", keywordAss=" + keywordAss + ", keywordIs=" + keywordIs
				+ ", keywordRegisters=" + keywordRegisters + ", keywordDeclares="
				+ keywordDeclares + ", keywordIncludes=" + keywordIncludes + "]";
	}


	public IKeywordStatement addInOrderStatement() {
		IKeywordStatement element = new KeywordInOrder();
		keywordInOrders.add(element);
		return element;
	}


	public IKeywordStatement addAsStatement() {
		IKeywordStatement element = new KeywordAs();
		keywordAss.add(element);
		return element;
	}


	public IKeywordStatement addIStatement() {
		IKeywordStatement element = new KeywordI();
		keywordIs.add(element);
		return element;
	}


	public IKeywordStatement addRegisterStatement() {
		IKeywordStatement element = new KeywordRegister();
		keywordRegisters.add(element);
		return element;
	}

	public IKeywordStatement addDeclareStatement() {
		IKeywordStatement element = new KeywordDeclare();
		keywordDeclares.add(element);
		return element;
	}

	public IKeywordStatement addIncludeStatement() {
		IKeywordStatement element = new KeywordInclude();
		keywordIncludes.add(element);
		return element;
	}

	public void includeRegister(List<IKeywordStatement> registers) throws JBehaviourParsingError {
		for(IKeywordStatement item:registers) {
			KeywordRegister register = (KeywordRegister) item;
			logger.info("Include register: " + register.getReference() + " with " + register.getKlass());
			keywordRegisters.add(register);
		}
	}

	public void includeDeclare(List<IKeywordStatement> declares) {
		for(IKeywordStatement item:declares) {
			KeywordDeclare declare = (KeywordDeclare) item;
			logger.info("Include declare: " + declare.getReference());
			keywordDeclares.add(item);
		}
	}

	public IKeywordStatement addReportStatement() {
		IKeywordStatement element = new KeywordReport();
		keywordReports.add(element);
		return element;
	}
}
