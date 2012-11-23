package org.jbehaviour.plugins.jdbc;


import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import org.jbehaviour.JBehaviourLauncher;
import org.jbehaviour.exception.JBehaviourPasingError;
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
	public void test() throws SQLException, InterruptedException, ClassNotFoundException, IOException, JBehaviourPasingError, JBehaviourRuntimeError {
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
