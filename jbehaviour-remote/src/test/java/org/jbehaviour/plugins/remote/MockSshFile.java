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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.sshd.server.SshFile;

public class MockSshFile implements SshFile {
	
	File localfile = null;
	File root = new File("src/test/resources/root");

	public MockSshFile(String file) {
		localfile = new File(root.getAbsoluteFile() + file);
	}

	private String normalize(File filename) {
		return filename.getAbsolutePath().replace(root.getAbsolutePath(), "").replace("\\", "/");
	}

	@Override
	public String getAbsolutePath() {
		return normalize(localfile);
	}

	@Override
	public String getName() {
		return localfile.getName();
	}

	@Override
	public String getOwner() {
		return "root";
	}

	@Override
	public boolean isDirectory() {
		return localfile.isDirectory();
	}

	@Override
	public boolean isFile() {
		return localfile.isFile();
	}

	@Override
	public boolean doesExist() {
		return localfile.exists();
	}

	@Override
	public boolean isReadable() {
		return localfile.canRead();
	}

	@Override
	public boolean isWritable() {
		return localfile.canWrite();
	}

	@Override
	public boolean isExecutable() {
		return localfile.canExecute();
	}

	@Override
	public boolean isRemovable() {
		return false;
	}

	@Override
	public SshFile getParentFile() {
		return new MockSshFile(localfile.getParent());
	}

	@Override
	public long getLastModified() {
		return System.currentTimeMillis();
	}

	@Override
	public boolean setLastModified(long time) {
		return false;
	}

	@Override
	public long getSize() {
		return localfile.length();
	}

	@Override
	public boolean mkdir() {
		return false;
	}

	@Override
	public boolean delete() {
		return false;
	}

	@Override
	public boolean create() throws IOException {
		return false;
	}

	@Override
	public void truncate() throws IOException {
	}

	@Override
	public boolean move(SshFile destination) {
		return false;
	}

	@Override
	public List<SshFile> listSshFiles() {
		List<SshFile> res = new ArrayList<SshFile>();
		for(File f : localfile.listFiles()) {
			res.add(new MockSshFile(normalize(f)));
		}
		return res;
	}

	@Override
	public OutputStream createOutputStream(long offset) throws IOException {
		return new FileOutputStream(localfile);
	}

	@Override
	public InputStream createInputStream(long offset) throws IOException {
		return new FileInputStream(localfile);
	}

	@Override
	public void handleClose() throws IOException {
	}

	@Override
	public String toString() {
		return "MockSshFile [localfile=" + localfile + ", root=" + root + "]";
	}
}
