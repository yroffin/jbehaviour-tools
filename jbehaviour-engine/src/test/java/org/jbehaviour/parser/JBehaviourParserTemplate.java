package org.jbehaviour.parser;

import static org.junit.Assert.*;

import java.io.IOException;

import org.jbehaviour.exception.JBehaviourPasingError;
import org.jbehaviour.parser.model.IKeywordStatement;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JBehaviourParserTemplate {

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
	public void testTemplateDeclaration() throws IOException, JBehaviourPasingError {
		IKeywordStatement parser = (new JBehaviourStatementParser("some template with $argument.get(0).member.get(\"another\").text")).parse();
		System.err.println(parser.toString());
		assertEquals(parser.get(0).getValue(),"some");
		assertEquals(parser.get(1).getValue(),"template");
		assertEquals(parser.get(2).getValue(),"with");
		assertEquals(parser.get(3).getValue(),"$argument.get(0).member.get(\"another\").text");
	}
}
