package org.jbehaviour.xref.impl;

import java.util.ArrayList;
import java.util.List;

import org.jbehaviour.report.IBehaviourReportRun;
import org.jbehaviour.xref.IBehaviourXRefSuite;

public class JBehaviourXRefSuite implements IBehaviourXRefSuite {

	private long time;
	private int tests;
	private int failures;
	private int errors;
	private int disabled;
	private List<IBehaviourReportRun> runs = new ArrayList<IBehaviourReportRun>();

	@Override
	public IBehaviourReportRun register(IBehaviourReportRun run) {
		if(run.isSkipped()) disabled++;
		if(run.hasFailures()) failures++;
		if(run.hasErrors()) errors++;
		tests++;
		time+=run.getDuration();
		runs.add(run);
		return run;
	}
	@Override
	public int getDisabled() {
		return disabled;
	}

	@Override
	public int getErrors() {
		return errors;
	}

	@Override
	public int getFailures() {
		return failures;
	}

	@Override
	public int getSkipped() {
		return 0;
	}

	@Override
	public String toString() {
		return "JBehaviourXRefSuite [time=" + time + ", tests=" + tests
				+ ", failures=" + failures + ", errors=" + errors
				+ ", disabled=" + disabled + ", runs=" + runs + "]";
	}
	@Override
	public int getTests() {
		return tests;
	}

	@Override
	public long getTime() {
		return time;
	}
	@Override
	public List<IBehaviourReportRun> getRuns() {
		return runs;
	}

}
