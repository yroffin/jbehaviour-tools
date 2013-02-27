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

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.jbehaviour.plugins.remote.IResourcesItem;

import com.sshtools.j2ssh.ScpClient;
import com.sshtools.j2ssh.sftp.SftpFile;
import com.sshtools.j2ssh.sftp.SftpSubsystemClient;

public class SftpFileSystemResource extends SslFileSystemResource {

	private SftpSubsystemClient session = null;

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
			boolean exist = false;
			try {
				exist = local != null && 
						local.getAttributes() != null && 
						local.getAttributes().getPermissions() != null;
			} catch(Exception e) {
				exist = false;
			}
			closeSession();
			return exist;
		}
		return false;
	}

	@Override
	public List<IResourcesItem> listdir(String directory) throws IOException {
		List<SftpFile> l = new ArrayList<SftpFile>();
		if (openSession()) {
			SftpFile result = session.openDirectory(directory);
			session.listChildren(result, l);
			closeSession();
		}
		
		List<IResourcesItem> res = new ArrayList<IResourcesItem>();
		for(SftpFile item : l) {
			res.add(new ResourcesItem(item));
		}
		return res;
	}

	
	@Override
	public List<IResourcesItem> put(String local, String remote) throws IOException {
		File localFile = new File(local);
		if(!localFile.exists()) {
			throw new IOException("File " + local + " does not exist !!!");
		}
		List<IResourcesItem> res = new ArrayList<IResourcesItem>();
		ScpClient sftp = ssh.openScpClient();
		if (sftp != null) {
			sftp.put(localFile.getAbsolutePath(), remote, false);
			res.add(new ResourcesItem(new File(local)));
		}
		return res;
	}

	@Override
	public List<IResourcesItem> get(String remote, String local) throws IOException {
		File localFile = new File(local);
		List<IResourcesItem> res = new ArrayList<IResourcesItem>();
		ScpClient sftp = ssh.openScpClient();
		if (sftp != null) {
			sftp.get(localFile.getAbsolutePath(), remote, false);
			res.add(new ResourcesItem(new File(local)));
			closeSession();
		}
		return res;
	}

	@Override
	public String toString() {
		return "SftpFileSystemResource [session=" + session + ", url=" + url
				+ "]";
	}

}
