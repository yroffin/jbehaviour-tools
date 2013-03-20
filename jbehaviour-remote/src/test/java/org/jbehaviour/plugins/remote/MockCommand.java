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

package org.jbehaviour.plugins.remote;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.sshd.server.Command;
import org.apache.sshd.server.Environment;
import org.apache.sshd.server.ExitCallback;

public class MockCommand implements Command, Runnable {

	private ExitCallback callback;
	private OutputStream err;
	private OutputStream out;
	private InputStream in;

	@Override
	public String toString() {
		return "MockCommand [callback=" + callback + ", err=" + err + ", out="
				+ out + ", in=" + in + "]";
	}

	@Override
	public void setInputStream(InputStream _in) {
		in = _in;
	}

	@Override
	public void setOutputStream(OutputStream _out) {
		out = _out;
	}

	@Override
	public void setErrorStream(OutputStream _err) {
		err = _err;
	}

	@Override
	public void setExitCallback(ExitCallback _callback) {
		callback = _callback;
	}

	byte[] toByte(String value) {
		byte[] r = new byte[value.length()];
		for (int i = 0; i < value.length(); i++) {
			r[i] = (byte) value.charAt(i);
		}
		return r;
	}

	@Override
	public void start(Environment _env) throws IOException {
		new Thread(this).start();
	}

	@Override
	public void destroy() {
	}

	@Override
	public void run() {
		try {
			System.err.println("Reading input");
			while(in.available() > 0) in.read();
			System.err.println("Writing output");
			System.err.println("Exiting ...");
            out.write(0);
            out.write("Exiting ...".getBytes());
            out.write('\n');
            out.flush();
			callback.onExit(0, "Exiting ...");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
