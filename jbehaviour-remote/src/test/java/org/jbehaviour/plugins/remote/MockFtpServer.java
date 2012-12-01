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
	 * Add the given directory and all it's files recursively
	 *
	 * @param dir
	 */
	public void addDir(File dir){
		FileSystem fileSystem = new WindowsFakeFileSystem();
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
