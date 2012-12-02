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
		search = registry.retrieve("noname",IKeywordStatement.statement.Then,"store last result as 'anotherRef'");
		assertNotNull(search);
		search.execute();
		search = registry.retrieve("noname",IKeywordStatement.statement.Given,"some template string as $anotherRef");
		assertNotNull(search);
		search.execute();
		search = registry.retrieve("noname",IKeywordStatement.statement.Given,"some template string as $anotherRef.getSubbean(1).getSimple()");
		assertNotNull(search);
		String result = (String) search.execute();
		assertEquals("2",result);
	}
}
