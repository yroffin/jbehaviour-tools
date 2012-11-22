package org.jbehaviour.parser;

import static org.junit.Assert.*;

import java.io.IOException;

import org.jbehaviour.exception.JBehaviourPasingError;
import org.jbehaviour.parser.model.FormalStory;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JBehaviourStoryParserTest {

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
	public void testSampleStory() throws IOException, JBehaviourPasingError {
		FormalStory parser = (new JBehaviourParser("src/test/resources/files/sample.story")).parse();
		System.err.println(parser.toString());
		assertEquals("some",parser.getScenarios().get(0).getKeywordGivens().get(0).get(0).getValue());
		assertEquals("precondition",parser.getScenarios().get(0).getKeywordGivens().get(0).get(1).getValue());
		assertEquals("yet",parser.getScenarios().get(0).getKeywordWhens().get(2).get(0).getValue());
		assertEquals("another",parser.getScenarios().get(0).getKeywordWhens().get(2).get(1).getValue());
		assertEquals("happens",parser.getScenarios().get(0).getKeywordThens().get(1).get(5).getValue());
		assertEquals("too",parser.getScenarios().get(0).getKeywordThens().get(1).get(6).getValue());
	}

	@Test
	public void testExtendedStory() throws IOException, JBehaviourPasingError {
		FormalStory parser = (new JBehaviourParser("src/test/resources/files/extended.story")).parse();
		System.err.println(parser.toString());
		assertEquals("org.jbehaviour.plugins.SampleSteps",parser.getFeature().getKeywordRegister().get(0).getKlass());
		assertEquals("some",parser.getScenarios().get(0).getKeywordGivens().get(0).get(0).getValue());
		assertEquals("precondition",parser.getScenarios().get(0).getKeywordGivens().get(0).get(1).getValue());
		assertEquals("yet",parser.getScenarios().get(0).getKeywordWhens().get(2).get(0).getValue());
		assertEquals("another",parser.getScenarios().get(0).getKeywordWhens().get(2).get(1).getValue());
		assertEquals("happens",parser.getScenarios().get(0).getKeywordThens().get(1).get(5).getValue());
		assertEquals("too",parser.getScenarios().get(0).getKeywordThens().get(1).get(6).getValue());
	}

	@Test
	public void testDeclareStory() throws IOException, JBehaviourPasingError {
		FormalStory parser = (new JBehaviourParser("src/test/resources/files/declare.story")).parse();
		System.err.println(parser.toString());
		assertEquals("ref001",parser.getFeature().getKeywordDeclare().get(0).getReference());
		assertEquals("ref002",parser.getFeature().getKeywordDeclare().get(1).getReference());
		assertEquals("some string 001",parser.getFeature().getKeywordDeclare().get(0).extractLiteralAsString(3));
		assertEquals("some string 002",parser.getFeature().getKeywordDeclare().get(1).extractLiteralAsString(3));
		assertEquals("result as resultat_du_test_1",parser.getScenarios().get(0).getKeywordStores().get(0).getStatement());
		assertEquals("result as resultat_du_test_2",parser.getScenarios().get(0).getKeywordStores().get(1).getStatement());
	}

	@Test
	public void testIncludeStory() throws IOException, JBehaviourPasingError {
		FormalStory parser = (new JBehaviourParser("src/test/resources/files/include.story")).parse();
		System.err.println(parser.toString());
	}
}
