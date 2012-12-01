package org.jbehaviour.plugins.remote;

import org.apache.sshd.server.FileSystemView;
import org.apache.sshd.server.SshFile;

public class MockFileSystemView implements FileSystemView {

	@Override
	public SshFile getFile(String file) {
		return new MockSshFile(file);
	}

	@Override
	public SshFile getFile(SshFile baseDir, String file) {
		return new MockSshFile(file);
	}

}
