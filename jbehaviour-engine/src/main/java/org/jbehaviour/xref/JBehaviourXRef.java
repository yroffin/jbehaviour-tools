package org.jbehaviour.xref;

import java.util.ArrayList;
import java.util.List;

import org.jbehaviour.report.IBehaviourReportRun;
import org.jbehaviour.report.impl.JBehaviourReportRun;

public class JBehaviourXRef implements IBehaviourXRef {

	List<IBehaviourReportRun> run = new ArrayList<IBehaviourReportRun>();

	@Override
	public Long start() {
		return System.currentTimeMillis();
	}

	@Override
	public Long stop(Long begin, String klass, String name, Object object, Object[] args,String text) {
		Long current = System.currentTimeMillis();
		Long duration = current - begin;
		run.add(new JBehaviourReportRun(klass,duration,name,object,args,text));
		return duration;
	}

	@Override
	public String toString() {
		return "JBehaviourXRef [run=" + run + "]";
	}

	@Override
	public List<IBehaviourReportRun> getRuns() {
		return run;
	}
}
