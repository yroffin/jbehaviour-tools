package org.jbehaviour;

import junit.framework.TestCase;

import org.jbehaviour.exception.JBehaviourPasingError;
import org.jbehaviour.exception.JBehaviourRuntimeError;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JBehaviourLauncherTest extends TestCase {

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
	public void testExecuteSample() throws JBehaviourPasingError, JBehaviourRuntimeError {
		assertEquals(true,JBehaviourLauncher.registerAndExecute("src/test/resources/files/sample.story"));
	}

	@Test
	public void testExecuteExtended() throws JBehaviourPasingError, JBehaviourRuntimeError {
		assertEquals(true,JBehaviourLauncher.registerAndExecute("src/test/resources/files/extended.story"));
	}

	@Test
	public void testJsonExtended() throws JBehaviourPasingError, JBehaviourRuntimeError {
		assertEquals(true,JBehaviourLauncher.registerAndExecute("src/test/resources/files/json.story"));
	}

	@Test
	public void testExecuteInclude() throws JBehaviourPasingError, JBehaviourRuntimeError {
		assertEquals(true,JBehaviourLauncher.registerAndExecute("src/test/resources/files/include.story"));
	}
}
