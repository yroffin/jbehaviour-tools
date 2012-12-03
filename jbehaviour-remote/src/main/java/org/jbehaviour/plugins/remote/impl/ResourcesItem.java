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

import org.jbehaviour.plugins.remote.IResourcesItem;

import com.sshtools.j2ssh.sftp.SftpFile;

public class ResourcesItem implements IResourcesItem {

	String name;
	String fullName;
	String longName;
	boolean canRead;
	boolean canWrite;
	long size;
	
	@Override
	public String toString() {
		return "ResourcesItem [name=" + name + ", fullName=" + fullName
				+ ", longName=" + longName + ", canRead=" + canRead
				+ ", canWrite=" + canWrite + ", size=" + size + "]";
	}

	/**
	 * create from SftpFile
	 * @param l
	 */
	public ResourcesItem(SftpFile l) {
		setName(l.getFilename());
		setLongName(l.getLongname());
		setCanRead(l.canRead());
		setCanWrite(l.canWrite());
		setSize(l.getAttributes().getSize().longValue());
		setFullName(l.getAbsolutePath());
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getLongName() {
		return longName;
	}

	@Override
	public void setLongName(String longName) {
		this.longName = longName;
	}

	@Override
	public boolean isCanRead() {
		return canRead;
	}

	@Override
	public void setCanRead(boolean canRead) {
		this.canRead = canRead;
	}

	@Override
	public boolean isCanWrite() {
		return canWrite;
	}

	@Override
	public void setCanWrite(boolean canWrite) {
		this.canWrite = canWrite;
	}

	@Override
	public long getSize() {
		return size;
	}

	@Override
	public void setSize(long _size) {
		this.size = _size;
	}
}
