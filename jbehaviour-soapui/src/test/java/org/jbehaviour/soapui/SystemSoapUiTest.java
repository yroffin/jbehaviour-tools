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

package org.jbehaviour.soapui;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.jbehaviour.exception.JBehaviourParsingError;
import org.jbehaviour.exception.JBehaviourRuntimeError;
import org.jbehaviour.impl.JBehaviourLauncher;
import org.jbehaviour.plugins.system.ISystemAsyncTread;
import org.jbehaviour.plugins.system.impl.SystemAsyncThread;
import org.junit.Test;

public class SystemSoapUiTest {
	@Test
	public void testSystemAsyncThreadWithStory() throws InterruptedException, JBehaviourParsingError, JBehaviourRuntimeError {
		if(System.getProperty("file.separator").compareTo("\\")==0) {
			/**
			 * check if mockservicerunner.bat is in the path
			 */
			List<String> arguments = new ArrayList<String>();
			arguments.add("mockservicerunner.bat");
			ISystemAsyncTread localThread = new SystemAsyncThread(arguments);
			localThread.start();
			int result = localThread.waitFor();
			/**
			 * make the test only if soapui is setup on system
			 */
			if(result == 0) {
				assertEquals(true,(new JBehaviourLauncher()).registerAndExecute("src/test/resources/soapui/windows.story"));
			}
		}
	}
}
