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

package org.jbehaviour.report;

import java.io.File;
import java.io.IOException;

public interface IBehaviourReportRun {

	/**
	 * arguments passed to the method
	 * @return
	 */
	Object[] getArgs();

	/**
	 * duration in millisecond
	 * @return
	 */
	Long getTime();

	/**
	 * step name
	 * @return
	 */
	String getName();

	/**
	 * get object on which we have applied
	 * the method invocation
	 * @return
	 */
	Object getObject();

	/**
	 * get step text (on annotation)
	 * @return
	 */
	String getText();

	/**
	 * get step text as a camel case naming methoc
	 * @return
	 */
	String getTextLikeMethod();

	/**
	 * get raw class
	 * @return
	 */
	String getKlass();

	/**
	 * get package
	 * @return
	 */
	String getPck();

	/**
	 * is this step was skipped ?
	 * @return
	 */
	boolean isSkipped();

	/**
	 * any errors ?
	 * @return
	 */
	boolean hasErrors();

	/**
	 * any failure ?
	 * @return
	 */
	boolean hasFailures();
	
	/**
	 * any stdout ?
	 * @return
	 */
	boolean hasStdout();
	
	/**
	 * any stderr ?
	 * @return
	 */
	boolean hasStderr();

	/**
	 * result of the method invocation
	 * @return
	 */
	Object getResult();

	/**
	 * retrieve exception (if any) thrown during
	 * the execution
	 * @return
	 */
	Exception getExcp();

	/**
	 * all output to stdout during run
	 * @return
	 */
	File getStdout();
	
	/**
	 * transform stdout to string buffer
	 * @return
	 * @throws IOException 
	 */
	String getStdoutAsString() throws IOException;

	/**
	 * all output to stderr during run
	 * @return
	 */
	File getStderr();
	
	/**
	 * transform stderr to string buffer
	 * @return
	 * @throws IOException 
	 */
	String getStderrAsString() throws IOException;

}
