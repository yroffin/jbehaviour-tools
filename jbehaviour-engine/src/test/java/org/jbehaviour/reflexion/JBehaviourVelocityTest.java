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
import java.util.ArrayList;
import java.util.List;

import org.jbehaviour.exception.JBehaviourParsingError;
import org.jbehaviour.exception.JBehaviourRuntimeError;
import org.jbehaviour.parser.model.IKeywordStatement;
import org.jbehaviour.plugins.ComplexBean;
import org.jbehaviour.plugins.ComplexForeachBean;
import org.jbehaviour.reflexion.impl.JBehaviourEnv;
import org.jbehaviour.reflexion.impl.JBehaviourReflexion;
import org.jbehaviour.xref.impl.JBehaviourXRef;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JBehaviourVelocityTest {

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
	public void testEvaluateObject() throws JBehaviourParsingError {
		IBehaviourEnv env = new JBehaviourEnv(new JBehaviourXRef());
		ComplexBean myBean = new ComplexBean();
		ComplexBean mySubBean = myBean.getSubbean(2);
		env.store("object001", myBean);
		ComplexForeachBean myBean1 = new ComplexForeachBean();
		env.store("object002", myBean1);
		/**
		 * myBean and mySubBean
		 */
		assertEquals(myBean, env.asObject("$object001"));
		assertEquals(1000,env.asObject("$object001.getSimple()"));
		assertEquals(1000,env.asObject("$object001.simple"));
		assertEquals(mySubBean,env.asObject("$object001.getSubbean(2)"));
		/**
		 * myBean1
		 */
		List<Integer> listInteger = new ArrayList<Integer>();
		List<String> listString = new ArrayList<String>();
		Integer i1 = new Integer(1);
		Integer i2 = new Integer(2);
		listInteger.add(i1);
		listInteger.add(i2);
		myBean1.setListInteger(listInteger);
		String s1 = new String("1");
		String s2 = new String("2");
		listString.add(s1);
		listString.add(s2);
		myBean1.setListString(listString);
		assertEquals(s2,env.asObject("$object002.getListString().get(1)"));
		@SuppressWarnings("unchecked")
		List<Integer> l1 = (List<Integer>) env.asObject("$object002.getListInteger()");
		int cmp = 1;
		for(Integer i : l1) {
			assertEquals(cmp++,i.intValue());
		}
	}

	@Test
	public void testVelocitySteps() throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, JBehaviourParsingError, JBehaviourRuntimeError {
		IBehaviourReflexion registry = new JBehaviourReflexion();
		registry.register("klass","org.jbehaviour.plugins.system.SystemSteps");
		registry.register("complex","org.jbehaviour.plugins.ComplexSteps");
		registry.register("velocity","org.jbehaviour.plugins.VelocitySteps");
		
		/**
		 * retrieve and execute on context
		 */
		IBehaviourReflexionContext search = null;
		search = registry.retrieve("noname",IKeywordStatement.statement.Given,"some precondition with complex object return");
		assertNotNull(search);
		search.execute();
		search = registry.retrieve("noname",IKeywordStatement.statement.Given,"store last result as 'anotherRef'");
		assertNotNull(search);
		search.execute();
		search = registry.retrieve("noname",IKeywordStatement.statement.Given,"some template reference as $anotherRef");
		assertNotNull(search);
		search.execute();
		search = registry.retrieve("noname",IKeywordStatement.statement.Given,"some template string as $anotherRef.getSubbean(1).getSimple()");
		assertNotNull(search);
		String result = (String) search.execute();
		assertEquals("2",result);
		search = registry.retrieve("noname",IKeywordStatement.statement.Given,"some template reference as $anotherRef.getSubbean(1).getSimple()");
		assertNotNull(search);
		Integer resultInteger = (Integer) search.execute();
		assertEquals(2,resultInteger.intValue());
	}
}
