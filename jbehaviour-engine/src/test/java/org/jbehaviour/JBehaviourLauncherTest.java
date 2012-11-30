package org.jbehaviour;

import junit.framework.TestCase;

import org.jbehaviour.exception.JBehaviourParsingError;
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
	public void testExecuteSample() throws JBehaviourParsingError, JBehaviourRuntimeError {
		assertEquals(true,JBehaviourLauncher.registerAndExecute("src/test/resources/files/sample.story"));
	}

	@Test
	public void testExecuteExtended() throws JBehaviourParsingError, JBehaviourRuntimeError {
		assertEquals(true,JBehaviourLauncher.registerAndExecute("src/test/resources/files/extended.story"));
	}

	@Test
	public void testJsonExtended() throws JBehaviourParsingError, JBehaviourRuntimeError {
		assertEquals(true,JBehaviourLauncher.registerAndExecute("src/test/resources/files/json.story"));
	}

	@Test
	public void testExecuteReport() throws JBehaviourParsingError, JBehaviourRuntimeError {
		assertEquals(false,JBehaviourLauncher.registerAndExecute("src/test/resources/report/report.story"));
	}

	@Test
	public void testExecuteReportError() throws JBehaviourParsingError, JBehaviourRuntimeError {
		assertEquals(false,JBehaviourLauncher.registerAndExecute("src/test/resources/report/report_error.story"));
	}

	@Test
	public void testExecuteReportFailure() throws JBehaviourParsingError, JBehaviourRuntimeError {
		assertEquals(false,JBehaviourLauncher.registerAndExecute("src/test/resources/report/report_failure.story"));
	}

	@Test
	public void testExecuteInclude() throws JBehaviourParsingError, JBehaviourRuntimeError {
		assertEquals(true,JBehaviourLauncher.registerAndExecute("src/test/resources/files/include.story"));
	}
}
