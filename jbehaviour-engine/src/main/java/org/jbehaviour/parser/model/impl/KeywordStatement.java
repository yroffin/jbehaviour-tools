package org.jbehaviour.parser.model.impl;

import java.util.ArrayList;
import java.util.List;

import org.jbehaviour.exception.JBehaviourPasingError;
import org.jbehaviour.parser.model.IKeywordStatement;
import org.jbehaviour.parser.model.IKeywordStatementElement;

public class KeywordStatement implements IKeywordStatement {

	statement type = statement.None;
	
	public String getStatement() {
		StringBuilder sb = new StringBuilder();
		for(IKeywordStatementElement item : elements) {
			if(sb.length()>0) sb.append(' ');
			sb.append(item.getValue());
		}
		return sb.toString();
	}

	public IKeywordStatementElement get(int index) {
		if(index>=elements.size()) return null;
		return elements.get(index);
	}

	protected List<IKeywordStatementElement> elements = new ArrayList<IKeywordStatementElement>();
	
	public void someWord(String value) {
		elements.add(new KeywordStatementElement(IKeywordStatement.declareType.Identifier,value));
	}

	@Override
	public boolean compareTo(IKeywordStatement _parsedStatement) {
		/**
		 * same size first
		 */
		if(elements.size() != _parsedStatement.size()) return false;
		/**
		 * then analyze the structure
		 */
		int matcher = 0;
		int index = 0;
		for(IKeywordStatementElement item : elements) {
			switch(item.getType()) {
				case String:
				case Reference:
				case Template:
				case Integer:
				case Json:
					matcher++;
					break;
				case Identifier:
					if(item.equals(_parsedStatement.get(index))) matcher++;
					break;
				default:
					/**
					 * force error
					 */
					matcher = 0;
					break;
			}
			index++;
		}
		return matcher == elements.size();
	}

	@Override
	public int size() {
		return elements.size();
	}

	@Override
	public List<IKeywordStatementElement> get() {
		return elements;
	}

	@Override
	public Integer extractLiteralAsInteger(int index) throws JBehaviourPasingError {
		if(elements.get(index).getType() == org.jbehaviour.parser.model.IKeywordStatement.declareType.Integer) {
			return new Integer(elements.get(index).getValue());
		}
		throw new JBehaviourPasingError("Type is not valid: " + elements.get(index).getType());
	}

	@Override
	public String extractLiteralAsString(int index) throws JBehaviourPasingError {
		if(elements.get(index).getType() == org.jbehaviour.parser.model.IKeywordStatement.declareType.String) {
			return elements.get(index).extractLiteralAsString();
		}
		if(elements.get(index).getType() == org.jbehaviour.parser.model.IKeywordStatement.declareType.Identifier) {
			return elements.get(index).getValue();
		}
		throw new JBehaviourPasingError("Type is not valid: " + elements.get(index).getType());
	}

	@Override
	public String getReference() throws JBehaviourPasingError {
		return null;
	}
	
	@Override
	public String getKlass() throws JBehaviourPasingError {
		return null;
	}

	@Override
	public statement getType() {
		return type;
	}

	@Override
	public org.jbehaviour.parser.model.IKeywordStatement.declareType getDeclareType() {
		return org.jbehaviour.parser.model.IKeywordStatement.declareType.None;
	}

	@Override
	public void someString(String value) {
		elements.add(new KeywordStatementElement(IKeywordStatement.declareType.String,value));
	}

	@Override
	public void someIdentifier(String value) {
		elements.add(new KeywordStatementElement(IKeywordStatement.declareType.Identifier,value));
	}

	@Override
	public void someReference(String value) {
		elements.add(new KeywordStatementElement(IKeywordStatement.declareType.Reference,value));
	}

	@Override
	public void someTemplate(String value) {
		elements.add(new KeywordStatementElement(IKeywordStatement.declareType.Template,value));
	}

	@Override
	public void someInteger(String value) {
		elements.add(new KeywordStatementElement(IKeywordStatement.declareType.Integer,value));
	}

	@Override
	public void someJson(String value) {
		elements.add(new KeywordStatementElement(IKeywordStatement.declareType.Json,value));
	}
}
