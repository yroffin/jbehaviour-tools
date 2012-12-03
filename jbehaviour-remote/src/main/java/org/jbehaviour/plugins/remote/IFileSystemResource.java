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

import java.io.IOException;
import java.util.List;

import org.jbehaviour.plugins.remote.impl.ResourcesItem;

public interface IFileSystemResource {
	public void open() throws IOException;
	public void close() throws IOException;
	public void setUrl(String url);
	
	/**
	 * behaviour method
	 * check if file exist on this resource
	 * @return
	 * @throws IOException 
	 */
	public boolean checkIfFileExist(String filename) throws IOException;
	
	/**
	 * list local or remote resources
	 * @param directory
	 * @return
	 * @throws IOException
	 */
	public List<ResourcesItem> listdir(String directory) throws IOException;
	
	/**
	 * execute local or remote commande
	 * @param command
	 * @return
	 * @throws IOException 
	 */
	public List<String> execute(String command) throws IOException;
}
