package org.jbehaviour.parser;

import static org.junit.Assert.*;

import java.io.IOException;

import org.jbehaviour.exception.JBehaviourPasingError;
import org.jbehaviour.parser.model.IKeywordStatement;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JBehaviourParserJson {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testJson1() throws IOException, JBehaviourPasingError {
		IKeywordStatement parser = (new JBehaviourStatementParser("some json with {'data':'data'}")).parse();
		System.err.println(parser.toString());
		assertEquals(parser.get(0).getValue(),"some");
		assertEquals(parser.get(1).getValue(),"json");
		assertEquals(parser.get(2).getValue(),"with");
		assertEquals(parser.get(3).getValue(),"{'data':'data'}");
	}

	@Test
	public void testJson2() throws IOException, JBehaviourPasingError {
		IKeywordStatement parser = (new JBehaviourStatementParser("some json with {'data':'data','myObject':{'anotherData':'some string'}}")).parse();
		System.err.println(parser.toString());
		assertEquals(parser.get(0).getValue(),"some");
		assertEquals(parser.get(1).getValue(),"json");
		assertEquals(parser.get(2).getValue(),"with");
		assertEquals(parser.get(3).getValue(),"{'data':'data','myObject':{'anotherData':'some string'}}");
	}
	@Test

	public void testJson3() throws IOException, JBehaviourPasingError {
		IKeywordStatement parser = (new JBehaviourStatementParser("some json with {'data':'data'\n,'myObject':\n{'anotherData':'some string'}\n}\n")).parse();
		System.err.println(parser.toString());
		assertEquals(parser.get(0).getValue(),"some");
		assertEquals(parser.get(1).getValue(),"json");
		assertEquals(parser.get(2).getValue(),"with");
		assertEquals(parser.get(3).getValue(),"{'data':'data'\n,'myObject':\n{'anotherData':'some string'}\n}");
	}
}
