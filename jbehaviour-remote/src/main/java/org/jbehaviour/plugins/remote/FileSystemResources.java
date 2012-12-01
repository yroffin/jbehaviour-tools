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
