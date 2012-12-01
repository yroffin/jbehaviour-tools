package org.jbehaviour.plugins.remote.impl;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class LocalFileSystemResource extends FileSystemResourceImpl {

	public LocalFileSystemResource(String url) throws MalformedURLException {
		super(url);
	}

	@Override
	public boolean checkIfFileExist(String filename) {
		File testFile = new File(getFile() + File.separatorChar + filename);
		return testFile.exists() && testFile.isFile();
	}

	@Override
	public List<ResourcesItem> listdir(String directory) {
		List<ResourcesItem> res = new ArrayList<ResourcesItem>();
		return res;
	}

	@Override
	public List<String> execute(String command) {
		// TODO Auto-generated method stub
		return null;
	}

}
