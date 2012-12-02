package org.jbehaviour.plugins.sikuli;

import static org.junit.Assert.*;

import org.jbehaviour.JBehaviourLauncher;
import org.jbehaviour.exception.JBehaviourParsingError;
import org.jbehaviour.exception.JBehaviourRuntimeError;
import org.junit.Test;

public class JBehaviourSikuliTest {
	@Test
	public void testSikuliSample() throws JBehaviourParsingError, JBehaviourRuntimeError {
		assertEquals(true,JBehaviourLauncher.registerAndExecute("src/test/resources/files/sikuli.story"));
	}
}
