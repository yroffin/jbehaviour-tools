package org.jbehaviour.xref;

import java.util.List;

import org.jbehaviour.report.IBehaviourReportRun;

public interface IBehaviourXRef {
	public Long start();
	public Long stop(Long begin, String klass, String name, Object object, Object[] args, String text);
	public List<IBehaviourReportRun> getRuns();
}
