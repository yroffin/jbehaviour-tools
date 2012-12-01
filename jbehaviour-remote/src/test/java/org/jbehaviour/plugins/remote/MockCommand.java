package org.jbehaviour.plugins.remote;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.sshd.server.Command;
import org.apache.sshd.server.Environment;
import org.apache.sshd.server.ExitCallback;

public class MockCommand implements Command {

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
		for(int i = 0;i<value.length();i++) {
			r[i] = (byte) value.charAt(i);
		}
		return r;
	}
	@Override
	public void start(Environment _env) throws IOException {
		out.write(toByte("host fictif>\n"));
		out.write(toByte("host fictif>a b\n"));
		out.write(toByte("host fictif>a b c\n"));
		out.flush();
		in.close();
	}

	@Override
	public void destroy() {
	}

}
