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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jbehaviour.report.IBehaviourReportRun;
import org.jbehaviour.report.impl.JBehaviourReportRun;
import org.jbehaviour.xref.IBehaviourXRef;
import org.jbehaviour.xref.IBehaviourXRefSuite;

public class JBehaviourXRef implements IBehaviourXRef {

	List<IBehaviourReportRun> runs = new ArrayList<IBehaviourReportRun>();
	
	@Override
	public boolean hasStdout() {
		for(IBehaviourReportRun item : runs) {
			if(item.hasStdout()) return true;
		}
		return false;
	}

	@Override
	public boolean hasStderr() {
		for(IBehaviourReportRun item : runs) {
			if(item.hasStderr()) return true;
		}
		return false;
	}

	@Override
	public String getStdoutAsString() throws IOException {
		StringBuilder sb = new StringBuilder();
		for(IBehaviourReportRun item : runs) {
			sb.append(item.getStdoutAsString());
		}
		return sb.toString();
	}

	@Override
	public String getStderrAsString() throws IOException {
		StringBuilder sb = new StringBuilder();
		for(IBehaviourReportRun item : runs) {
			sb.append(item.getStderrAsString());
		}
		return sb.toString();
	}

	@Override
	public List<IBehaviourReportRun> getRuns() {
		return runs;
	}

	String name;

	public JBehaviourXRef() {
	}
	
	@Override
	public Long start() {
		return System.currentTimeMillis();
	}

	@Override
	public Long stop(
			String pck,
			Long begin,
			String klass,
			String name,
			Object object,
			Object[] args,
			String text,
			File stdout,
			File stderr,
			Object result,
			Exception excp) {
		Long current = System.currentTimeMillis();
		Long duration = current - begin;
		runs.add(new JBehaviourReportRun(runs.size(),pck,klass,duration,name,object,args,text, stdout, stderr, result, excp));
		return duration;
	}

	@Override
	public Map<String, IBehaviourXRefSuite> getRunsByScenario() {
		Map<String,IBehaviourXRefSuite> result = new HashMap<String,IBehaviourXRefSuite>();
		for(IBehaviourReportRun item : runs) {
			if(!result.containsKey(item.getPck())) {
				result.put(item.getPck(), new JBehaviourXRefSuite());
			}
			result.get(item.getPck()).register(item);
		}
		return result;
	}

	@Override
	public void release() {
	}

	@Override
	public int getDisabled() {
		int counter = 0;
		for(IBehaviourReportRun step : runs) {
			if(step.isSkipped()) {
				counter ++;
			}
		}
		return counter;
	}

	@Override
	public int getErrors() {
		int counter = 0;
		for(IBehaviourReportRun step : runs) {
			if(step.hasErrors()) {
				counter ++;
			}
		}
		return counter;
	}

	@Override
	public int getFailures() {
		int counter = 0;
		for(IBehaviourReportRun step : runs) {
			if(step.hasFailures()) {
				counter ++;
			}
		}
		return counter;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int getTests() {
		return runs.size();
	}

	@Override
	public long getTime() {
		long counter = 0;
		for(IBehaviourReportRun step : runs) {
			counter+=step.getTime();
		}
		return counter;
	}

	@Override
	public String toString() {
		return "JBehaviourXRef [run=" + runs + ", getDisabled()="
				+ getDisabled() + ", getErrors()=" + getErrors()
				+ ", getFailures()=" + getFailures() + ", getName()="
				+ getName() + ", getTests()=" + getTests() + ", getTime()="
				+ getTime() + "]";
	}
}
