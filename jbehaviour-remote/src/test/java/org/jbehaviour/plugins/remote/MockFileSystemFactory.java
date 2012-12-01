package org.jbehaviour.plugins.remote;

import java.io.IOException;

import org.apache.sshd.common.Session;
import org.apache.sshd.server.FileSystemFactory;
import org.apache.sshd.server.FileSystemView;

public class MockFileSystemFactory implements FileSystemFactory {

	@Override
	public FileSystemView createFileSystemView(Session session)
			throws IOException {
		return new MockFileSystemView();
	}

}
