package org.jbehaviour.plugins.remote.impl;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import com.sshtools.j2ssh.SshClient;
import com.sshtools.j2ssh.authentication.AuthenticationProtocolState;
import com.sshtools.j2ssh.authentication.PasswordAuthenticationClient;
import com.sshtools.j2ssh.transport.AbstractKnownHostsKeyVerification;
import com.sshtools.j2ssh.transport.TransportProtocolException;
import com.sshtools.j2ssh.transport.publickey.SshPublicKey;

public abstract class SslFileSystemResource extends FileSystemResourceImpl {

	@Override
	public boolean checkIfFileExist(String filename) throws IOException {
		System.err.println("Using abstract method checkIfFileExist !!!");
		return false;
	}


	@Override
	public List<ResourcesItem> listdir(String directory) throws IOException {
		System.err.println("Using abstract method listdir !!!");
		List<ResourcesItem> res = new ArrayList<ResourcesItem>();
		return res;
	}

	@Override
	public List<String> execute(String command) throws IOException {
		System.err.println("Using abstract method !!!");
		List<String> res = new ArrayList<String>();
		return res;
	}

	@Override
	public void close() throws IOException {
		ssh.disconnect();
		super.close();
	}

	private class LocalKnownHostsKeyVerification extends
			AbstractKnownHostsKeyVerification {

		@Override
		public boolean verifyHost(String arg0, SshPublicKey arg1)
				throws TransportProtocolException {
			return true;
		}

		public LocalKnownHostsKeyVerification(File tempFile) throws IOException {
			super(tempFile.getAbsolutePath());
			tempFile.delete();
		}

		@Override
		public void onHostKeyMismatch(String arg0, SshPublicKey arg1,
				SshPublicKey arg2) throws TransportProtocolException {
		}

		@Override
		public void onUnknownHost(String arg0, SshPublicKey arg1)
				throws TransportProtocolException {
		}

	}

	SshClient ssh = new SshClient();

	public SslFileSystemResource(String url) throws MalformedURLException {
		super(url);
	}

	@Override
	public void open() throws IOException {
		if (ssh.isConnected()) return;

		/**
		 * SSL connect layer
		 */
		ssh.connect(
				getHost(),
				new LocalKnownHostsKeyVerification(File.createTempFile("xxx",
						"xxx")));
		if (!ssh.isConnected()) {
			throw new IOException("Unable to connect to " + url);
		}

		PasswordAuthenticationClient pwd = new PasswordAuthenticationClient();
		pwd.setUsername(getUser());
		pwd.setPassword(getPassword());
		int result = ssh.authenticate(pwd);

		if (result == AuthenticationProtocolState.FAILED) {
			throw new IOException("The authentication failed");
		}
		if (result == AuthenticationProtocolState.PARTIAL) {
			throw new IOException("The authentication succeeded but another"
					+ "authentication is required");
		}

		if (result == AuthenticationProtocolState.COMPLETE) {
			System.out.println("The authentication is complete");
		}
	}

}
