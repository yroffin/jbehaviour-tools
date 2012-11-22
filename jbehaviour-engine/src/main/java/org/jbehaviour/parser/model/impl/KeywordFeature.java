package org.jbehaviour.parser.model.impl;

import java.util.ArrayList;
import java.util.List;

import org.jbehaviour.exception.JBehaviourPasingError;
import org.jbehaviour.parser.model.IKeywordStatement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KeywordFeature extends KeywordStatement {
	static Logger logger = LoggerFactory.getLogger(KeywordFeature.class);

	public KeywordFeature() {
		type = IKeywordStatement.statement.Feature;
	}

	List<IKeywordStatement> keywordInOrders = new ArrayList<IKeywordStatement>();
	List<IKeywordStatement> keywordAss = new ArrayList<IKeywordStatement>();
	List<IKeywordStatement> keywordIs = new ArrayList<IKeywordStatement>();
	List<IKeywordStatement> keywordRegisters = new ArrayList<IKeywordStatement>();
	List<IKeywordStatement> keywordDeclares = new ArrayList<IKeywordStatement>();
	List<IKeywordStatement> keywordIncludes = new ArrayList<IKeywordStatement>();
	
	public List<IKeywordStatement> getKeywordInclude() {
		return keywordIncludes;
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

	public void includeRegister(List<IKeywordStatement> registers) throws JBehaviourPasingError {
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
}
