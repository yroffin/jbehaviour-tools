package org.jbehaviour.plugins.remote.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import com.sshtools.j2ssh.sftp.SftpFile;
import com.sshtools.j2ssh.sftp.SftpSubsystemClient;

public class SftpFileSystemResource extends SslFileSystemResource {

	SftpSubsystemClient session = null;

	public SftpFileSystemResource(String url) throws MalformedURLException {
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
		session = ssh.openSftpChannel();
		return session != null;
	}

	private void closeSession() throws IOException {
		session.close();
	}

	@Override
	public boolean checkIfFileExist(String filename) throws IOException {
		if (openSession()) {
			SftpFile local = session.openFile(filename, 0);
			closeSession();
			return local != null;
		}
		return false;
	}

	@Override
	public List<ResourcesItem> listdir(String directory) throws IOException {
		List<SftpFile> l = new ArrayList<SftpFile>();
		if (openSession()) {
			SftpFile result = session.openDirectory(directory);
			session.listChildren(result, l);
			closeSession();
		}
		
		List<ResourcesItem> res = new ArrayList<ResourcesItem>();
		for(SftpFile item : l) {
			res.add(new ResourcesItem(item));
		}
		return res;
	}

}
