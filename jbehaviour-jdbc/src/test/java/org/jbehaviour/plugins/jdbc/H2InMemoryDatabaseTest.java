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

package org.jbehaviour.plugins.jdbc;


import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import org.jbehaviour.JBehaviourLauncher;
import org.jbehaviour.exception.JBehaviourParsingError;
import org.jbehaviour.exception.JBehaviourRuntimeError;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import junit.framework.TestCase;

public class H2InMemoryDatabaseTest extends TestCase {
	static Logger logger = LoggerFactory.getLogger(H2InMemoryDatabaseTest.class);
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	protected void setUp() throws Exception {
		super.setUp();
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void test() throws SQLException, InterruptedException, ClassNotFoundException, IOException, JBehaviourParsingError, JBehaviourRuntimeError {
		H2MemoryDriver server = new H2MemoryDriver();
		server.start();
		server.load(new File("src/test/resources/datadump.sql"));
		
		/**
		 * test code here
		 */
		boolean result = JBehaviourLauncher.registerAndExecute("src/test/resources/jdbc.story");

		server.stop();
		assertEquals(result,true);
	}

}
