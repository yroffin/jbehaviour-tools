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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.mockftpserver.fake.FakeFtpServer;
import org.mockftpserver.fake.UserAccount;
import org.mockftpserver.fake.filesystem.DirectoryEntry;
import org.mockftpserver.fake.filesystem.FileEntry;
import org.mockftpserver.fake.filesystem.FileSystem;
import org.mockftpserver.fake.filesystem.UnixFakeFileSystem;
import org.mockftpserver.fake.filesystem.WindowsFakeFileSystem;

/**
 * FTP server mock to be used with unit tests.
 *
 * @author diniz
 *
 */
public class MockFtpServer {

	private FakeFtpServer fakeFtpServer;

	public MockFtpServer(int port, String userName, String password, File homeDir){
		fakeFtpServer = new FakeFtpServer();
		fakeFtpServer.setServerControlPort(port);
		fakeFtpServer.addUserAccount(new UserAccount(userName, password, homeDir.getAbsolutePath()));
	}

	/**
	 * read this file in one single output string
	 * @param file
	 * @return
	 * @throws IOException
	 */
	private String slurp(File file) throws IOException {
        FileReader in = new FileReader(file);
        StringBuffer sb = new StringBuffer();
        int ch;
        while ((ch = in.read()) != -1) {
            sb.append((char) ch);
        }
        in.close();
        return sb.toString();
    }

	/**
	 * return fake
	 * @return
	 */
	private FileSystem getFakeFileSystem() {
		if(System.getProperty("file.separator").compareTo("/")==0) {
			return new UnixFakeFileSystem();
		} else {
			return new WindowsFakeFileSystem();
		}
	}

	/**
	 * Add the given directory and all it's files recursively
	 *
	 * @param dir
	 */
	public void addDir(File dir){
		FileSystem fileSystem = getFakeFileSystem();
		fileSystem.add(new DirectoryEntry(dir.getAbsolutePath()));
		for(File file : dir.listFiles()){
			try {
				if(file.isFile()) {
					fileSystem.add(new FileEntry(file.getAbsolutePath(), slurp(file)));
				} else {
					addDir(file);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		fakeFtpServer.setFileSystem(fileSystem);
	}

	/**
	 * Start the server
	 */
	public void start(){
		fakeFtpServer.start();
	}

	/**
	 * Stop the server
	 */
	public void stop(){
		fakeFtpServer.stop();
	}

}
