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

package org.jbehaviour.plugins.system;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class SystemAsyncThread extends Thread {
	
	private ProcessBuilder pb;
	private int result = -1;

	public SystemAsyncThread(List<String> args) {
		pb = new ProcessBuilder(args);
	}

	OutputStream stdin = null;
	InputStream stderr = null;
	InputStream stdout = null;

	@Override
	public void run() {
		System.err.println("Starting");
		try {
			Process process = pb.start();
			pb.redirectErrorStream(false);

			stdin  = process.getOutputStream ();
			stderr = process.getErrorStream ();
			stdout = process.getInputStream ();

			int line=0;
			int car=0;
			for(int octet=0;(car = stdout.read()) > 0;octet++) {
			    System.out.println ("Stdout: " + car);
			}
			for(int octet=0;(car = stderr.read()) > 0;octet++) {
			    System.out.println ("Stderr: " + car);
			}

			result = process.waitFor();
		} catch (IOException e) {
			e.printStackTrace();
			result = -2;
		} catch (InterruptedException e) {
			e.printStackTrace();
			result = -3;
		}
	}
}
