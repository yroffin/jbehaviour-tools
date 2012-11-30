package org.jbehaviour.xref.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jbehaviour.report.IBehaviourReportRun;
import org.jbehaviour.report.impl.JBehaviourReportRun;
import org.jbehaviour.xref.IBehaviourXRef;

public class JBehaviourXRef implements IBehaviourXRef {

	List<IBehaviourReportRun> run = new ArrayList<IBehaviourReportRun>();

	@Override
	public Long start() {
		return System.currentTimeMillis();
	}

	@Override
	public Long stop(String pck, Long begin, String klass, String name, Object object, Object[] args,String text) {
		Long current = System.currentTimeMillis();
		Long duration = current - begin;
		run.add(new JBehaviourReportRun(pck,klass,duration,name,object,args,text));
		return duration;
	}

	@Override
	public Map<String, List<IBehaviourReportRun>> getRunsByScenario() {
		Map<String,List<IBehaviourReportRun>> result = new HashMap<String,List<IBehaviourReportRun>>();
		for(IBehaviourReportRun item : run) {
			if(!result.containsKey(item.getPck())) {
				result.put(item.getPck(), new ArrayList<IBehaviourReportRun>());
			}
			result.get(item.getPck()).add(item);
		}
		return result;
	}

	@Override
	public String toString() {
		return "JBehaviourXRef [run=" + run + "]";
	}
}
