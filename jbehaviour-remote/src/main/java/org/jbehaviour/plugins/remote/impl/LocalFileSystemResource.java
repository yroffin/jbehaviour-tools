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
