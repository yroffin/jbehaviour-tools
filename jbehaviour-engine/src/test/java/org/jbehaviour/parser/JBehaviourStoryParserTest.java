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

package org.jbehaviour.parser;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.jbehaviour.exception.JBehaviourParsingError;
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
	public void testSampleStory() throws IOException, JBehaviourParsingError {
		FormalStory parser = (new JBehaviourParser(new File("src/test/resources/files/sample.story"))).parse();
		System.err.println(parser.toString());
		assertEquals("some",parser.getScenarios().get(0).getKeywordGivens().get(0).get(0).getValue());
		assertEquals("precondition",parser.getScenarios().get(0).getKeywordGivens().get(0).get(1).getValue());
		assertEquals("yet",parser.getScenarios().get(0).getKeywordWhens().get(2).get(0).getValue());
		assertEquals("another",parser.getScenarios().get(0).getKeywordWhens().get(2).get(1).getValue());
		assertEquals("happens",parser.getScenarios().get(0).getKeywordThens().get(1).get(5).getValue());
		assertEquals("too",parser.getScenarios().get(0).getKeywordThens().get(1).get(6).getValue());
	}

	@Test
	public void testExtendedStory() throws IOException, JBehaviourParsingError {
		FormalStory parser = (new JBehaviourParser(new File("src/test/resources/files/extended.story"))).parse();
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
	public void testDeclareStory() throws IOException, JBehaviourParsingError {
		FormalStory parser = (new JBehaviourParser(new File("src/test/resources/files/declare.story"))).parse();
		System.err.println(parser.toString());
		assertEquals("ref001",parser.getFeature().getKeywordDeclare().get(0).getReference());
		assertEquals("ref002",parser.getFeature().getKeywordDeclare().get(1).getReference());
		assertEquals("some string 001",parser.getFeature().getKeywordDeclare().get(0).extractLiteralAsString(3));
		assertEquals("some string 002",parser.getFeature().getKeywordDeclare().get(1).extractLiteralAsString(3));
		assertEquals("store last result as resultat_du_test_1",parser.getScenarios().get(0).getKeywordGivens().get(2).getStatement());
		assertEquals("store last result as resultat_du_test_2",parser.getScenarios().get(0).getKeywordGivens().get(3).getStatement());
	}

	@Test
	public void testIncludeStory() throws IOException, JBehaviourParsingError {
		FormalStory parser = (new JBehaviourParser(new File("src/test/resources/files/include.story"))).parse();
		System.err.println(parser.toString());
	}
}
