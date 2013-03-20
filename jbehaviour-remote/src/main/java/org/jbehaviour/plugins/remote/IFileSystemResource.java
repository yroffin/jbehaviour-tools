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
import java.util.ArrayList;
import java.util.List;

public interface IFileSystemResource {
	/**
	 * open this resource
	 * 
	 * @throws IOException
	 */
	public void open() throws IOException;

	/**
	 * close this resource
	 * 
	 * @throws IOException
	 */
	public void close() throws IOException;

	/**
	 * fix url
	 * 
	 * @param url
	 */
	public void setUrl(String url);

	/**
	 * check if file exist on this resource
	 * 
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public boolean checkIfFileExist(String filename) throws IOException;

	/**
	 * list local or remote resources
	 * 
	 * @param directory
	 * @return
	 * @throws IOException
	 */
	public List<IResourcesItem> listdir(String directory) throws IOException;

	public class ConsoleStream {
		List<String> stdout;
		List<String> stderr;
		int result;

		public ConsoleStream() {
			stdout = new ArrayList<String>();
			stderr = new ArrayList<String>();
			result = 0;
		}

		public List<String> getStdout() {
			return stdout;
		}

		public List<String> getStderr() {
			return stderr;
		}

		public int getResult() {
			return result;
		}

		public void setResult(int result) {
			this.result = result;
		}

		@Override
		public String toString() {
			return "ConsoleStream [stdout=" + stdout + ", stderr=" + stderr
					+ ", result=" + result + "]";
		}
	}

	/**
	 * execute local or remote commande
	 * 
	 * @param command
	 * @return
	 * @throws IOException
	 */
	public ConsoleStream execute(String command) throws IOException;

	/**
	 * put on remote from input to output
	 * 
	 * @param local
	 * @param remote
	 * @return
	 * @throws IOException
	 */
	public List<IResourcesItem> put(String local, String remote)
			throws IOException;

	/**
	 * get from remote from input to output
	 * 
	 * @param local
	 * @param remote
	 * @return
	 * @throws IOException
	 */
	public List<IResourcesItem> get(String remote, String local)
			throws IOException;
}
