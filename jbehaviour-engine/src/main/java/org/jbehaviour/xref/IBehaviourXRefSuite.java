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

package org.jbehaviour.xref;

import java.io.IOException;
import java.util.List;

import org.jbehaviour.report.IBehaviourReportRun;

public interface IBehaviourXRefSuite {
	/**
	 * getTimeStamp
	 * @return
	 */
	public String getTimeStamp();
	/**
	 * get all step disabled
	 * @return
	 */
	public int getDisabled();
	/**
	 * get all step in error
	 * @return
	 */
	public int getErrors();
	/**
	 * get all step in failure
	 * @return
	 */
	public int getFailures();
	/**
	 * get all step (counter)
	 * @return
	 */
	public int getTests();
	/**
	 * get all global time
	 * @return
	 */
	public long getTime();
	/**
	 * register a new testcase
	 * @param run
	 * @return
	 */
	public IBehaviourReportRun register(IBehaviourReportRun run);
	/**
	 * retrieve runs
	 * @return
	 */
	public List<IBehaviourReportRun> getRuns();
	/**
	 * 
	 * @return
	 */
	int getSkipped();
	/**
	 * runs analysis
	 * @return
	 */
	public boolean hasStdout();
	/**
	 * runs analysis
	 * @return
	 */
	public boolean hasStderr();
	/**
	 * runs stdout
	 * @return
	 * @throws IOException 
	 */
	public String getStdoutAsString() throws IOException;
	/**
	 * runs stderr
	 * @return
	 * @throws IOException 
	 */
	public String getStderrAsString() throws IOException;
	/**
	 * runs stdout
	 * @return
	 * @throws IOException 
	 */
	public String getStdoutAsHtml() throws IOException;
	/**
	 * runs stderr
	 * @return
	 * @throws IOException 
	 */
	public String getStderrAsHtml() throws IOException;
}
