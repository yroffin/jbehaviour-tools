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
