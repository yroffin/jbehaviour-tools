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
	Long getDuration();

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
