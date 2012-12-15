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

package org.jbehaviour.async;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.jbehaviour.exception.JBehaviourParsingError;
import org.jbehaviour.exception.JBehaviourRuntimeError;
import org.jbehaviour.impl.JBehaviourLauncher;
import org.jbehaviour.plugins.system.ISystemAsyncTread;
import org.jbehaviour.plugins.system.SystemSteps;
import org.jbehaviour.reflexion.impl.JBehaviourEnv;
import org.jbehaviour.reflexion.impl.JBehaviourReflexion;
import org.jbehaviour.xref.impl.JBehaviourXRef;
import org.junit.Test;

public class SystemAsyncThreadTest {
	@Test
	public void testSystemAsyncThread() throws InterruptedException, JBehaviourParsingError, JBehaviourRuntimeError, IOException {
		SystemSteps step = new SystemSteps();
		step.env = new JBehaviourEnv(null,new JBehaviourReflexion(),new JBehaviourXRef());
		
		ISystemAsyncTread result = null;
		if(System.getProperty("file.separator").compareTo("\\")==0) {
			result = step.startCommandWithArgsAsReference("cmd.exe", "/C echo SystemAsyncThreadTest", "test001");
		} else {
			result = step.startCommandWithArgsAsReference("echo", "SystemAsyncThreadTest", "test001");
		}

		result = step.waitForAsyncCommandReference((ISystemAsyncTread) step.env.getObject("test001"));
		assertEquals("SystemAsyncThreadTest",result.getStdoutAsList().get(0));
	}

	@Test
	public void testSystemAsyncThreadWithStory() throws InterruptedException, JBehaviourParsingError, JBehaviourRuntimeError {
		if(System.getProperty("file.separator").compareTo("\\")==0) {
			assertEquals(true,(new JBehaviourLauncher()).registerAndExecute("src/test/resources/system/windows.story"));
		} else {
			assertEquals(true,(new JBehaviourLauncher()).registerAndExecute("src/test/resources/system/unix.story"));
		}
	}
}
