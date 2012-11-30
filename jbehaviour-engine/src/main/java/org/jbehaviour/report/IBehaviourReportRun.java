package org.jbehaviour.report;

public interface IBehaviourReportRun {

	Object[] getArgs();

	Long getDuration();

	String getName();

	Object getObject();

	String getText();

	String getTextLikeMethod();

	String getKlass();

	String getPck();

	boolean isSkipped();

	boolean hasErrors();

	boolean hasFailures();

	boolean hasStdout();

	boolean hasStderr();

}
