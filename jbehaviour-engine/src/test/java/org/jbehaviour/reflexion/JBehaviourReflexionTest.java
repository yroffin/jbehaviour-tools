package org.jbehaviour.reflexion;

import static org.junit.Assert.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.jbehaviour.exception.JBehaviourParsingError;
import org.jbehaviour.exception.JBehaviourRuntimeError;
import org.jbehaviour.parser.model.IKeywordStatement;
import org.jbehaviour.reflexion.impl.JBehaviourReflexion;
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
		IBehaviourReflexion registry = new JBehaviourReflexion();
		registry.register("klass","org.jbehaviour.plugins.SampleSteps");
		
		/**
		 * retrieve and execute on context
		 */
		IBehaviourReflexionContext search = null;
		search = registry.retrieve(IKeywordStatement.statement.Given,"some precondition");
		assertNotNull(search);
		search.execute();
		search = registry.retrieve(IKeywordStatement.statement.Given,"some precondition with one 'parameter'");
		assertNotNull(search);
		search.execute();
		search = registry.retrieve(IKeywordStatement.statement.Given,"some precondition with one '10'");
		assertNotNull(search);
		search.execute();
		search = registry.retrieve(IKeywordStatement.statement.Given,"some precondition with int 10");
		assertNotNull(search);
		search.execute();
		search = registry.retrieve(IKeywordStatement.statement.Given,"multiply 100 by 50");
		int result = (Integer) search.execute();
		assertEquals(result,5000);
	}

	@Test
	public void testComplexSteps() throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, JBehaviourParsingError, JBehaviourRuntimeError {
		IBehaviourReflexion registry = new JBehaviourReflexion();
		registry.register("klass","org.jbehaviour.plugins.ComplexSteps");
		
		/**
		 * retrieve and execute on context
		 */
		IBehaviourReflexionContext search = null;
		search = registry.retrieve(IKeywordStatement.statement.Given,"some precondition with complex object return");
		assertNotNull(search);
		search.execute();
		search = registry.retrieve(IKeywordStatement.statement.Store,"result as 'anotherRef'");
		assertNotNull(search);
		search.execute();
		search = registry.retrieve(IKeywordStatement.statement.Then,"some condition with my bean $anotherRef");
		assertNotNull(search);
		assertTrue((Boolean) search.execute());
	}

	@Test
	public void testLocalSystem() throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, JBehaviourParsingError, JBehaviourRuntimeError {
		IBehaviourReflexion registry = new JBehaviourReflexion();
		registry.register("klass","org.jbehaviour.plugins.system.SystemSteps");
		
		/**
		 * retrieve and execute on context
		 */
		IBehaviourReflexionContext search = null;
		search = registry.retrieve(IKeywordStatement.statement.Given,"set property 'webdriver.chrome.driver' to 'C:\\tmp'");
		assertNotNull(search);
		search.execute();
		assertEquals(System.getProperty("webdriver.chrome.driver"),"C:\\tmp");
	}
}
