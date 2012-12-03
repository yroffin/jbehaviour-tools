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
