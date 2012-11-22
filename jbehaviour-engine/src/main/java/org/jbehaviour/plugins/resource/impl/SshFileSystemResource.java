package org.jbehaviour.plugins.resource.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;

import com.sshtools.j2ssh.session.SessionChannelClient;

public class SshFileSystemResource extends SslFileSystemResource {

	SessionChannelClient session = null;

	public SshFileSystemResource(String url) throws MalformedURLException {
		super(url);
	}

	@Override
	public void open() throws IOException {
		super.open();
	}

	@Override
	public void close() throws IOException {
		session.close();
		super.close();
	}

	private boolean openSession() throws IOException {
		/**
		 * open a new channel
		 */
		session = ssh.openSessionChannel();

		/**
		 * emulate a terminal
		 */
		session.requestPseudoTerminal("ansi", 132, 24, 132, 24, "");
		return session.startShell();
	}

	private void write(String cmd) throws IOException {
		/** Writing to the session OutputStream */
		OutputStream out = session.getOutputStream();
		out.write(cmd.getBytes());
	}

	private void flushSession() throws IOException {
		/**
		 * Reading from the session InputStream
		 */
		InputStream in = session.getInputStream();
		byte buffer[] = new byte[255];
		int read;
		while ((read = in.read(buffer)) > 0) {
			String out = new String(buffer, 0, read);
			System.out.println(out + ":" + read);
		}

		in = session.getStderrInputStream();
		buffer = new byte[255];
		while ((read = in.read(buffer)) > 0) {
			String out = new String(buffer, 0, read);
			System.out.println(out);
		}
	}

	private void closeSession() throws IOException {
		session.close();
	}

	@Override
	public boolean checkIfFileExist(String filename) throws IOException {
		if (openSession()) {
			write("[ -f "+filename+" ];exit $?\n");
			flushSession();
			closeSession();
		}
		return session.getExitCode() == 0;
	}

}
