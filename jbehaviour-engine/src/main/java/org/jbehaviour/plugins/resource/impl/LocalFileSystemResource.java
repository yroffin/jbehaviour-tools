package org.jbehaviour.plugins.resource.impl;

import java.io.File;
import java.net.MalformedURLException;

public class LocalFileSystemResource extends FileSystemResourceImpl {

	public LocalFileSystemResource(String url) throws MalformedURLException {
		super(url);
	}

	@Override
	public boolean checkIfFileExist(String filename) {
		File testFile = new File(getFile() + File.separatorChar + filename);
		return testFile.exists() && testFile.isFile();
	}

}
