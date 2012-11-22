package org.jbehaviour.parser.model;

import java.util.List;

import org.jbehaviour.exception.JBehaviourPasingError;

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
		Include
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
	 * @throws JBehaviourPasingError 
	 */
	public Integer extractLiteralAsInteger(int index) throws JBehaviourPasingError;
	public String  extractLiteralAsString(int index) throws JBehaviourPasingError;

	public String getStatement();
	public statement getType();

	/**
	 * Register statement
	 * @throws JBehaviourPasingError 
	 */
	public String getReference() throws JBehaviourPasingError;
	public String getKlass() throws JBehaviourPasingError;

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
