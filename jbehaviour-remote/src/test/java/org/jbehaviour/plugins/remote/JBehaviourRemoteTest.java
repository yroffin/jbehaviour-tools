package org.jbehaviour.plugins.remote;

import static org.junit.Assert.*;

import java.io.File;

import org.jbehaviour.JBehaviourLauncher;
import org.jbehaviour.exception.JBehaviourParsingError;
import org.jbehaviour.exception.JBehaviourRuntimeError;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JBehaviourRemoteTest {
	private MockFtpServer ftpMock;
	private MockSftpServer sshMock;

	@Before
	public void setup() throws Exception{
		/**
		 * FTP mock
		 */
		ftpMock = new MockFtpServer(21,"TestUsername", "TestPassword", new File("src/test/resources"));
		ftpMock.addDir(new File("src/test/resources/root"));
		ftpMock.start();

		/**
		 * SSH/SFTP/SCP Mock
		 */
		sshMock = new MockSftpServer();
		try {
			sshMock.start();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	@After
	public void tearDown() throws InterruptedException{
		ftpMock.stop();
		sshMock.stop();
	}

	@Test
	public void testRemoteSample() throws JBehaviourParsingError, JBehaviourRuntimeError {
		assertEquals(true,JBehaviourLauncher.registerAndExecute("src/test/resources/files/remote.story"));
	}
}
