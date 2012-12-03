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
	public void testTemplateDeclaration() throws IOException, JBehaviourParsingError {
		IKeywordStatement parser = (new JBehaviourStatementParser("some template with $argument.get(0).member.get(\"another\").text")).parse();
		System.err.println(parser.toString());
		assertEquals(parser.get(0).getValue(),"some");
		assertEquals(parser.get(1).getValue(),"template");
		assertEquals(parser.get(2).getValue(),"with");
		assertEquals(parser.get(3).getValue(),"$argument.get(0).member.get(\"another\").text");
	}
}
