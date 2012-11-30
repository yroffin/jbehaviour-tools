package org.jbehaviour.xref;

import java.util.List;
import java.util.Map;

import org.jbehaviour.report.IBehaviourReportRun;

public interface IBehaviourXRef {
	/**
	 * start counter
	 * @return
	 */
	public Long start();
	/**
	 * retrieve run sort by scenario
	 * @return
	 */
	public Map<String, List<IBehaviourReportRun>> getRunsByScenario();
	/**
	 * stop counter for this run, and store in session
	 * @param begin
	 * @param pck
	 * @param klass
	 * @param name
	 * @param object
	 * @param args
	 * @param text
	 * @return
	 */
	public Long stop(String pck, Long begin, String klass, String name, Object object, Object[] args, String text);
}
