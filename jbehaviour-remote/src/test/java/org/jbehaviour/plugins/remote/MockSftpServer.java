package org.jbehaviour.plugins.remote;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

import org.apache.sshd.SshServer;
import org.apache.sshd.common.NamedFactory;
import org.apache.sshd.common.util.SecurityUtils;
import org.apache.sshd.server.Command;
import org.apache.sshd.server.FileSystemFactory;
import org.apache.sshd.server.ForwardingFilter;
import org.apache.sshd.server.PasswordAuthenticator;
import org.apache.sshd.server.PublickeyAuthenticator;
import org.apache.sshd.server.command.ScpCommandFactory;
import org.apache.sshd.server.keyprovider.PEMGeneratorHostKeyProvider;
import org.apache.sshd.server.keyprovider.SimpleGeneratorHostKeyProvider;
import org.apache.sshd.server.session.ServerSession;
import org.apache.sshd.server.sftp.SftpSubsystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MockSftpServer {
	static Logger logger = LoggerFactory.getLogger(MockSftpServer.class);

	SshServer sshd = null;

	public MockSftpServer() {
		sshd = SshServer.setUpDefaultServer();
		sshd.setPort(22);

        if (SecurityUtils.isBouncyCastleRegistered()) {
            sshd.setKeyPairProvider(new PEMGeneratorHostKeyProvider("key.pem"));
        } else {
            sshd.setKeyPairProvider(new SimpleGeneratorHostKeyProvider("key.ser"));
        }

        FileSystemFactory fileSystemFactory = new MockFileSystemFactory();
		sshd.setFileSystemFactory(fileSystemFactory);

		sshd.setShellFactory(new MockProcessShellFactory());

		sshd.setPasswordAuthenticator(new PasswordAuthenticator() {
			@Override
			public boolean authenticate(String username, String password,
					ServerSession session) {
				logger.info("Authenticate with " + username);
				return username != null && username.equals(password);
			}
		});

		sshd.setPublickeyAuthenticator(new PublickeyAuthenticator() {
			@Override
			public boolean authenticate(String username, PublicKey key,
					ServerSession session) {
				logger.info("Authenticate with key");
				return true;
			}
		});

		sshd.setCommandFactory(new ScpCommandFactory());

		List<NamedFactory<Command>> namedFactoryList = new ArrayList<NamedFactory<Command>>();
		namedFactoryList.add(new SftpSubsystem.Factory());
		sshd.setSubsystemFactories(namedFactoryList);

		sshd.setForwardingFilter(new ForwardingFilter() {
			public boolean canForwardAgent(ServerSession session) {
				return true;
			}

			public boolean canForwardX11(ServerSession session) {
				return true;
			}

			public boolean canListen(InetSocketAddress address,
					ServerSession session) {
				return true;
			}

			public boolean canConnect(InetSocketAddress address,
					ServerSession session) {
				return true;
			}
		});
	}

	public void start() throws IOException {
		sshd.start();
	}

	public void stop() throws InterruptedException {
		sshd.stop();
	}
}
