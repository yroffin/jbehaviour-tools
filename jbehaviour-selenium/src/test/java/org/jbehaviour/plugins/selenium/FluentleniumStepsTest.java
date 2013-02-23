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

package org.jbehaviour.plugins.selenium;

import static org.junit.Assert.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.jbehaviour.exception.JBehaviourParsingError;
import org.jbehaviour.exception.JBehaviourRuntimeError;
import org.jbehaviour.parser.model.IKeywordStatement;
import org.jbehaviour.reflexion.IBehaviourEnv;
import org.jbehaviour.reflexion.IBehaviourReflexionContext;
import org.jbehaviour.reflexion.impl.JBehaviourEnv;
import org.jbehaviour.reflexion.impl.JBehaviourReflexion;
import org.jbehaviour.xref.impl.JBehaviourXRef;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FluentleniumStepsTest {

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
	public void test() throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, JBehaviourParsingError, JBehaviourRuntimeError {
		IBehaviourEnv env = new JBehaviourEnv(null,new JBehaviourReflexion(),new JBehaviourXRef());
		env.register("selenium","org.jbehaviour.plugins.selenium.FluentleniumSteps");
		env.register("system","org.jbehaviour.plugins.system.SystemSteps");
		
		/**
		 * retrieve and execute on context
		 */
		IBehaviourReflexionContext search = null;
		search = env.retrieve("noname",IKeywordStatement.statement.Given,"launch the html navigator");
		assertNotNull(search);
		search.execute(env);
		search = env.retrieve("noname",IKeywordStatement.statement.When,"i goto to 'http://www.google.com'");
		assertNotNull(search);
		search.execute(env);
		search = env.retrieve("noname",IKeywordStatement.statement.Then,"close browser driver");
		assertNotNull(search);
		search.execute(env);
	}

}
