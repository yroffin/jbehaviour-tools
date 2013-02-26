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

package org.jbehaviour.plugins.remote.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

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
		open();
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

	private void flushSession(List<String> res) throws IOException {
		/**
		 * Reading from the session InputStream
		 */
		InputStream in = session.getInputStream();
		byte buffer[] = new byte[255];
		int read;
		while ((read = in.read(buffer)) > 0) {
			String out = new String(buffer, 0, read);
			res.add(out);
		}

		in = session.getStderrInputStream();
		buffer = new byte[255];
		while ((read = in.read(buffer)) > 0) {
			String out = new String(buffer, 0, read);
			res.add(out);
		}
	}

	private void closeSession() throws IOException {
		session.close();
	}

	@Override
	public List<String> execute(String command) throws IOException {
		List<String> res = new ArrayList<String>();
		if(openSession()) {
			write(command);
			flushSession(res);
			closeSession();
		}
		return res;
	}

	@Override
	public String toString() {
		return "SshFileSystemResource [session=" + session + ", url=" + url
				+ "]";
	}
}
