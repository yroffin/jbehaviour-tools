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

package org.jbehaviour.plugins.system.impl;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.jbehaviour.plugins.system.ISystemAsyncTread;


public class SystemAsyncThread extends Thread implements ISystemAsyncTread {
	
	private ProcessBuilder pb;
	private int result = -1;

	BufferedWriter stdin = null;
	InputStream stderr = null;
	InputStream stdout = null;
	
	int iStdout = 0;
	int iStderr = 0;
	StringBuilder sbStdout = new StringBuilder();
	StringBuilder sbStderr = new StringBuilder();

	List<String> stdoutAsList = new ArrayList<String>();
	List<String> stderrAsList = new ArrayList<String>();

	public SystemAsyncThread(List<String> args) {
		pb = new ProcessBuilder(args);
	}

	@Override
	public void run() {
		System.err.println("Starting ...");
		try {
			System.err.println("start");

			/**
			 * start the process
			 */
			Process process = pb.start();

			/**
			 * get stdin, stdout and stderr
			 * stream
			 */
			stdin  = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
			stderr = process.getErrorStream();
			stdout = process.getInputStream();

			int car=0;
			
			/**
			 * dump stdout
			 */
			for(iStdout=0;(car = stdout.read()) > 0;iStdout++) {
				switch(car) {
					case 13:
						break;
					case 10:
						String value = sbStdout.toString();
						stdoutAsList.add(value);
					    System.out.println (value);
					    sbStdout.setLength(0);
						break;
					default:
						sbStdout.append((char) car);
				}
			}
			
			/**
			 * dump stderr
			 */
			for(iStderr=0;(car = stderr.read()) > 0;iStderr++) {
				switch(car) {
				case 13:
					break;
				case 10:
					String value = sbStderr.toString();
					stderrAsList.add(value);
				    System.err.println (value);
				    sbStderr.setLength(0);
					break;
				default:
					sbStderr.append((char) car);
				}
			}

			/**
			 * sync wait
			 */
			result = process.waitFor();
		} catch (IOException e) {
			e.printStackTrace();
			result = -2;
		} catch (InterruptedException e) {
			e.printStackTrace();
			result = -3;
		}
	}
	
	@Override
	public synchronized List<String> getStdoutAsList() {
		return stdoutAsList;
	}

	@Override
	public synchronized List<String> getStderrAsList() {
		return stderrAsList;
	}

	@Override
	public synchronized boolean ready() {
		return stdout != null;
	}

	@Override
	public void write(String string) throws IOException {
		if(stdin == null) {
			throw new IOException("stdin is null");
		}
		stdin.write(string);
		stdin.flush();
	}

	@Override
	public int getResult() {
		return result;
	}

	@Override
	public void waitFor() throws InterruptedException {
		this.join();
	}

	public int getiStdout() {
		return iStdout;
	}

	public int getiStderr() {
		return iStderr;
	}
}
