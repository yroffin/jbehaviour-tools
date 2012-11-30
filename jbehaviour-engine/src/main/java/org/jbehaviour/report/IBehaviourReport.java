package org.jbehaviour.report;

import java.io.File;
import java.io.IOException;

import org.jbehaviour.reflexion.IBehaviourReflexion;

public interface IBehaviourReport {
	void init();
	void render(IBehaviourReflexion registry, File template, File output) throws IOException;
}
