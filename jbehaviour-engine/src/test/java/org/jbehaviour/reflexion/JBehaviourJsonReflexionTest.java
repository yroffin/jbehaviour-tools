package org.jbehaviour.reflexion;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import junit.framework.TestCase;

import org.jbehaviour.exception.JBehaviourParsingError;
import org.jbehaviour.exception.JBehaviourRuntimeError;
import org.jbehaviour.parser.model.IKeywordStatement;
import org.jbehaviour.plugins.ComplexJsonBean;
import org.jbehaviour.reflexion.impl.JBehaviourReflexion;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JBehaviourJsonReflexionTest extends TestCase {

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
	public void testJsonSteps() throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, JBehaviourParsingError, JBehaviourRuntimeError {
		IBehaviourReflexion registry = new JBehaviourReflexion();
		registry.register("complex","org.jbehaviour.plugins.ComplexSteps");
		registry.register("json","org.jbehaviour.plugins.JsonSteps");
		
		/**
		 * retrieve and execute on context
		 */
		IBehaviourReflexionContext search = null;
		search = registry.retrieve("noname",IKeywordStatement.statement.Given,"some precondition with complex object return");
		assertNotNull(search);
		search.execute();
		search = registry.retrieve("noname",IKeywordStatement.statement.Given,"some json as {\"field1\":\"x\",\"field2\":\"y\",\"field3\":9}");
		assertNotNull(search);
		ComplexJsonBean result = (ComplexJsonBean) search.execute();
		assertEquals("x",result.getField1());
		assertEquals("y",result.getField2());
		assertEquals(9,result.getField3());
	}
}
