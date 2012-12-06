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

import java.io.IOException;

import org.jbehaviour.exception.JBehaviourParsingError;
import org.jbehaviour.parser.model.IKeywordStatement;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JBehaviourStatementParserTest {

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
	public void testSampleGivenSomePrecondition() throws IOException, JBehaviourParsingError {
		IKeywordStatement parser = (new JBehaviourStatementParser("some precondition")).parse();
		System.err.println(parser.toString());
		assertEquals(parser.get(0).getValue(),"some");
		assertEquals(parser.get(1).getValue(),"precondition");
	}

	@Test
	public void testSampleParameter() throws IOException, JBehaviourParsingError {
		IKeywordStatement parser = (new JBehaviourStatementParser("some $z $b $a to be ordered")).parse();
		System.err.println(parser.toString());
		assertEquals(parser.get(0).getValue(),"some");
		assertEquals(parser.get(1).getValue(),"$z");
		assertEquals(parser.get(2).getValue(),"$b");
		assertEquals(parser.get(3).getValue(),"$a");
	}

	@Test
	public void testSampleGivenSomePreconditionWithArgument() throws IOException, JBehaviourParsingError {
		IKeywordStatement parser = (new JBehaviourStatementParser("some precondition with $argument")).parse();
		System.err.println(parser.toString());
		assertEquals(parser.get(0).getValue(),"some");
		assertEquals(parser.get(1).getValue(),"precondition");
		assertEquals(parser.get(2).getValue(),"with");
		assertEquals(parser.get(3).getValue(),"$argument");
	}

	@Test
	public void testSampleGivenSomePreconditionWithString() throws IOException, JBehaviourParsingError {
		IKeywordStatement parser = (new JBehaviourStatementParser("some precondition          with 'argument  with  blank'")).parse();
		System.err.println(parser.toString());
		assertEquals(parser.get(0).getValue(),"some");
		assertEquals(parser.get(1).getValue(),"precondition");
		assertEquals(parser.get(2).getValue(),"with");
		assertEquals(parser.get(3).getValue(),"'argument  with  blank'");
		parser = (new JBehaviourStatementParser("some  precondition  with \"argument  with  blank\"")).parse();
		System.err.println(parser.toString());
		assertEquals(parser.get(0).getValue(),"some");
		assertEquals(parser.get(1).getValue(),"precondition");
		assertEquals(parser.get(2).getValue(),"with");
		assertEquals(parser.get(3).getValue(),"\"argument  with  blank\"");
		parser = (new JBehaviourStatementParser("some  precondition  with \"argument  $with  blank\"")).parse();
		System.err.println(parser.toString());
		assertEquals(parser.get(0).getValue(),"some");
		assertEquals(parser.get(1).getValue(),"precondition");
		assertEquals(parser.get(2).getValue(),"with");
		assertEquals(parser.get(3).getValue(),"\"argument  $with  blank\"");
		parser = (new JBehaviourStatementParser("some  precondition  with \"argument  $with  blank\" with other words after")).parse();
		System.err.println(parser.toString());
		assertEquals(parser.get(0).getValue(),"some");
		assertEquals(parser.get(1).getValue(),"precondition");
		assertEquals(parser.get(2).getValue(),"with");
		assertEquals(parser.get(3).getValue(),"\"argument  $with  blank\"");
		assertEquals(parser.get(5).getValue(),"other");
	}

	/**
	 * compare two string parsed
	 * @param sa
	 * @param sb
	 * @param target
	 * @throws IOException
	 * @throws JBehaviourParsingError 
	 */
	public void compare(String sa, String sb, boolean target) throws IOException, JBehaviourParsingError {
		IKeywordStatement a = (new JBehaviourStatementParser(sa)).parse();
		IKeywordStatement b = (new JBehaviourStatementParser(sb)).parse();
		System.err.println(a.toString());
		System.err.println(b.toString());
		assertTrue(a.compareTo(b) == target);
	}

	@Test
	public void testSampleCompareParsedItems() throws IOException, JBehaviourParsingError {
		compare("some precondition          with 'argument  with  blank' after",
				"some precondition with $argument after", true);
		compare("some precondition          with \"argument  with  blank\" after 'some other'",
				"some precondition with $argument after $another", true);
		compare("some precondition          with after",
				"some precondition with $argument after", false);
	}
}
