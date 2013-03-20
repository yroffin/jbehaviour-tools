package org.jbehaviour.plugins.remote;

import org.apache.sshd.server.Command;
import org.apache.sshd.server.CommandFactory;

public class MockScpCommandFactory implements CommandFactory {

	@Override
	public Command createCommand(String command) {
		return new MockCommand();
	}

}
