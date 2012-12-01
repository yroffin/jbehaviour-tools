package org.jbehaviour.plugins.remote;

import org.apache.sshd.common.Factory;
import org.apache.sshd.server.Command;

public class MockProcessShellFactory implements Factory<Command> {

	@Override
	public Command create() {
		return new MockCommand();
	}

}
