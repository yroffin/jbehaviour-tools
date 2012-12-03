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

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.jbehaviour.plugins.remote.impl.LocalFileSystemResource;
import org.jbehaviour.plugins.remote.impl.SftpFileSystemResource;
import org.jbehaviour.plugins.remote.impl.SshFileSystemResource;
import org.junit.Assert;

public class FileSystemResources {
	static private Map<String,IFileSystemResource> allResources = new HashMap<String,IFileSystemResource>();
	
	static public IFileSystemResource get(String key) {
		Assert.assertNotNull(key);
		Assert.assertNotNull(allResources.get(key));
		return allResources.get(key);
	}

	static public IFileSystemResource store(String key, String type, String url) throws MalformedURLException {
		if(allResources.containsKey(key)) {
			return get(key);
		}
		
		if(type.startsWith("local")) {
			allResources.put(key, new LocalFileSystemResource(url));
		}

		if(type.startsWith("ssh")) {
			allResources.put(key, new SshFileSystemResource(url));
		}

		if(type.startsWith("sftp")) {
			allResources.put(key, new SftpFileSystemResource(url));
		}

		return get(key);	
	}
}
