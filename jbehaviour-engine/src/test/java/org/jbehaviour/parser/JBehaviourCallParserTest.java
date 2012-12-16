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
import org.jbehaviour.parser.template.IKeywordCall;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JBehaviourCallParserTest {

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
	public void testCallParser001() throws IOException, JBehaviourParsingError {
		IKeywordCall call = (new JBehaviourCallParser("$object.get().another( 6 ).is( \"toto\" ).not( ).get( 1.2 , \"b\")")).parse();
		System.err.println(call);
		assertEquals("object",call.getIdentifier());
		assertEquals(call.getElement(0).getValue(),"get");
		assertEquals(call.getElement(1).getValue(),"another");
		assertEquals(call.getElement(1).toArray()[0],6);
		assertEquals(call.getElement(2).getValue(),"is");
		assertEquals(call.getElement(2).toArray()[0],"toto");
		assertEquals(call.getElement(3).getValue(),"not");
		assertEquals(call.getElement(4).getValue(),"get");
		assertEquals(call.getElement(4).toArray()[0],1.2);
		assertEquals(call.getElement(4).toArray()[1],"b");
	}
}
