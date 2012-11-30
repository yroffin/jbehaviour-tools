package org.jbehaviour.xref.impl;

import java.io.File;
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
		runs.add(new JBehaviourReportRun(pck,klass,duration,name,object,args,text, stdout, stderr, result, excp));
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
			counter+=step.getDuration();
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
