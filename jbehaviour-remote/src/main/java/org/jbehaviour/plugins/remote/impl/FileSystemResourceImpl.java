package org.jbehaviour.plugins.remote.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.jbehaviour.plugins.remote.IFileSystemResource;

public abstract class FileSystemResourceImpl implements IFileSystemResource {

	protected String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	URL urlDecode;

	public FileSystemResourceImpl(String url) throws MalformedURLException {
		this.url = url;
		/**
		 * url decoding
		 */
		urlDecode = new URL(url.replace("ssh","http").replace("sftp","http"));
		System.err.println(urlDecode.toString());
	}

	public String getProtocol() {
		return urlDecode.getProtocol();
	}

	public String getUser() {
		return urlDecode.getUserInfo().split(":")[0];
	}

	public String getPassword() {
		/**
		 * take care about empty password
		 */
		String[] password = urlDecode.getUserInfo().split(":");
		if(password.length==2) return password[1];
		else return "";
	}

	public String getHost() {
		return urlDecode.getHost();
	}

	public int getPort() {
		return urlDecode.getPort();
	}

	public String getPath() {
		return urlDecode.getPath();
	}

	public String getFile() {
		return urlDecode.getFile();
	}

	public void open() throws IOException {
	}

	public void close() throws IOException {
	}

	public boolean checkIfFileExist(String filename) throws IOException {
		return false;
	}
}