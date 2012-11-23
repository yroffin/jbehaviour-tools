package org.jbehaviour.plugins.system;

import java.io.FileWriter;
import java.io.IOException;

import org.jbehaviour.annotation.EnvReference;
import org.jbehaviour.annotation.Store;
import org.jbehaviour.reflexion.IBehaviourEnv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StoreSteps {
	Logger logger = LoggerFactory.getLogger(StoreSteps.class);

	@EnvReference
	public IBehaviourEnv env = null;

    @Store("result as $reference")
    public Object storeReference(String reference) {
    	logger.info("Store as " + reference);
    	return env.store(reference, env.getObject("result"));
    }

    @Store("in file $filename")
    public void storeFile(String filename) throws IOException {
    	logger.info("Store in file " + filename + " / " + env.getObject("result"));
    	FileWriter myFile = new FileWriter(filename);
    	myFile.write(env.getObject("result")+"");
    	myFile.close();
    }
}
