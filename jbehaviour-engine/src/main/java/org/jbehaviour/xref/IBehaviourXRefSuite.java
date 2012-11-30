package org.jbehaviour.xref;

import java.util.List;

import org.jbehaviour.report.IBehaviourReportRun;

public interface IBehaviourXRefSuite {
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
	int getSkipped();
}
