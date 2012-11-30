package org.jbehaviour.report;

import java.io.File;
import java.io.IOException;

public interface IBehaviourReport {
	void init();
	void render(IBehaviourReportRun ctx, File template, File output) throws IOException;
}
