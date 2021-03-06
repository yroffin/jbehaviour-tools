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

package org.jbehaviour.reflexion;

import static org.junit.Assert.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.jbehaviour.exception.JBehaviourParsingError;
import org.jbehaviour.exception.JBehaviourRuntimeError;
import org.jbehaviour.parser.model.IKeywordStatement;
import org.jbehaviour.reflexion.impl.JBehaviourEnv;
import org.jbehaviour.reflexion.impl.JBehaviourReflexion;
import org.jbehaviour.xref.impl.JBehaviourXRef;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JBehaviourReflexionTest {

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
	public void testSampleSteps() throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, JBehaviourParsingError, JBehaviourRuntimeError {
		IBehaviourEnv env = new JBehaviourEnv(null,new JBehaviourReflexion(),new JBehaviourXRef());
		env.register("klass","org.jbehaviour.plugins.SampleSteps");
		
		/**
		 * retrieve and execute on context
		 */
		IBehaviourReflexionContext search = null;
		search = env.retrieve("noname",IKeywordStatement.statement.Given,"some precondition");
		assertNotNull(search);
		search.execute(env);
		search = env.retrieve("noname",IKeywordStatement.statement.Given,"some precondition with one 'parameter'");
		assertNotNull(search);
		search.execute(env);
		search = env.retrieve("noname",IKeywordStatement.statement.Given,"some precondition with one '10'");
		assertNotNull(search);
		search.execute(env);
		search = env.retrieve("noname",IKeywordStatement.statement.Given,"some precondition with int 10");
		assertNotNull(search);
		search.execute(env);
		search = env.retrieve("noname",IKeywordStatement.statement.Given,"multiply 100 by 50");
		int result = (Integer) search.execute(env);
		assertEquals(result,5000);
	}

	@Test
	public void testComplexSteps() throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, JBehaviourParsingError, JBehaviourRuntimeError {
		IBehaviourEnv env = new JBehaviourEnv(null,new JBehaviourReflexion(),new JBehaviourXRef());
		env.register("klass","org.jbehaviour.plugins.system.SystemSteps");
		env.register("klass","org.jbehaviour.plugins.ComplexSteps");
		
		/**
		 * retrieve and execute on context
		 */
		IBehaviourReflexionContext search = null;
		search = env.retrieve("noname",IKeywordStatement.statement.Given,"some precondition with complex object return");
		assertNotNull(search);
		search.execute(env);
		search = env.retrieve("noname",IKeywordStatement.statement.Given,"store last result as 'anotherRef'");
		assertNotNull(search);
		search.execute(env);
		search = env.retrieve("noname",IKeywordStatement.statement.Then,"some condition with my bean $anotherRef");
		assertNotNull(search);
		assertTrue((Boolean) search.execute(env));
	}

	@Test
	public void testLocalSystem() throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, JBehaviourParsingError, JBehaviourRuntimeError {
		IBehaviourEnv env = new JBehaviourEnv(null,new JBehaviourReflexion(),new JBehaviourXRef());
		env.register("klass","org.jbehaviour.plugins.system.SystemSteps");
		
		/**
		 * retrieve and execute on context
		 */
		IBehaviourReflexionContext search = null;
		search = env.retrieve("noname",IKeywordStatement.statement.Given,"set property 'webdriver.chrome.driver' to 'C:\\tmp'");
		assertNotNull(search);
		search.execute(env);
		assertEquals(System.getProperty("webdriver.chrome.driver"),"C:\\tmp");
	}
}
