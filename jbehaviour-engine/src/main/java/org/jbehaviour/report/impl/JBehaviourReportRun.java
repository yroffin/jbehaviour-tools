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

package org.jbehaviour.report.impl;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import org.jbehaviour.report.IBehaviourReportRun;

public class JBehaviourReportRun implements IBehaviourReportRun {

	private Long duration;
	private String klass;
	private String name;
	private String text;
	private String textLikeMethod;
	private Object object;
	private Object[] args;
	private String pck;
	private Object result;
	private Exception excp;
	private File stdout;
	private File stderr;

	/**
	 * create this run report
	 * @param _pck
	 * @param _klass
	 * @param _duration
	 * @param _name
	 * @param _object
	 * @param _args
	 * @param _text
	 * @param _excp 
	 * @param _result 
	 * @param _result 
	 * @param stderr 
	 */
	public JBehaviourReportRun(String _pck, String _klass, Long _duration, String _name, Object _object, Object[] _args, String _text, File _stdout, File _stderr, Object _result, Exception _excp) {
		stdout = _stdout;
		stderr = _stderr;
		result = _result;
		excp = _excp;
		pck = _pck;
		klass = _klass;
		duration = _duration;
		name = _name;
		object = _object;
		args = _args.clone();
		text = _text;
		StringBuilder sb = new StringBuilder();
		for(String item : _text.split(" ")) {
			String value = item.replace("$", "").toLowerCase();
			if(sb.length() > 0) {
				sb.append(value.substring(0, 1).toUpperCase());
			} else {
				sb.append(value.substring(0, 1).toLowerCase());
			}
			sb.append(value.substring(1));
		}
		textLikeMethod = sb.toString();
	}

	
	@Override
	public File getStdout() {
		return stdout;
	}


	@Override
	public File getStderr() {
		return stderr;
	}


	@Override
	public Object getResult() {
		return result;
	}

	@Override
	public Exception getExcp() {
		return excp;
	}

	@Override
	public String getPck() {
		return pck;
	}

	@Override
	public String getKlass() {
		return klass;
	}

	@Override
	public String getText() {
		return text;
	}

	@Override
	public String getTextLikeMethod() {
		return textLikeMethod;
	}

	@Override
	public Long getTime() {
		return duration;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Object getObject() {
		return object;
	}

	@Override
	public Object[] getArgs() {
		return args;
	}

	@Override
	public boolean isSkipped() {
		return false;
	}

	@Override
	public boolean hasErrors() {
		return false;
	}

	@Override
	public boolean hasFailures() {
		return excp != null;
	}

	@Override
	public boolean hasStdout() {
		return getStdout() != null;
	}

	@Override
	public boolean hasStderr() {
		return getStderr() != null;
	}

	@Override
	public String toString() {
		return "JBehaviourReportRun [duration=" + duration + ", klass=" + klass
				+ ", name=" + name + ", text=" + text + ", textLikeMethod="
				+ textLikeMethod + ", object=" + object + ", args="
				+ Arrays.toString(args) + ", pck=" + pck + ", result=" + result
				+ ", excp=" + excp + "]";
	}

	/**
	 * all bytes to string
	 * @param file
	 * @return
	 * @throws IOException
	 */
	private String slurp(File file) throws IOException {
        FileReader in = new FileReader(file);
        StringBuffer sb = new StringBuffer();
        int ch;
        while ((ch = in.read()) != -1) {
            sb.append((char) ch);
        }
        in.close();
        return sb.toString();
    }

	@Override
	public String getStdoutAsString() throws IOException {
		return slurp(getStdout());
	}

	@Override
	public String getStderrAsString() throws IOException {
		return slurp(getStderr());
	}
}
