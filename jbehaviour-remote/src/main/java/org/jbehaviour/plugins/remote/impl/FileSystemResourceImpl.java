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

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jbehaviour.plugins.remote.IFileSystemResource;
import org.jbehaviour.plugins.remote.IResourcesItem;

public abstract class FileSystemResourceImpl implements IFileSystemResource {

	protected String url;

	public String getUrl() {
		return url;
	}

	@Override
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

	@Override
	public void open() throws IOException {
	}

	@Override
	public void close() throws IOException {
	}

	@Override
	public boolean checkIfFileExist(String filename) throws IOException {
		return false;
	}

	@Override
	public List<IResourcesItem> put(String local, String remote) throws IOException {
		return new ArrayList<IResourcesItem>();
	}

	@Override
	public List<IResourcesItem> get(String remote, String local) throws IOException {
		return new ArrayList<IResourcesItem>();
	}	
}
