package org.jbehaviour.plugins.system;

import java.io.FileWriter;
import java.io.IOException;

import org.jbehaviour.annotation.EnvReference;
import org.jbehaviour.annotation.Given;
import org.jbehaviour.annotation.Then;
import org.jbehaviour.reflexion.IBehaviourEnv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SystemSteps {
	Logger logger = LoggerFactory.getLogger(SystemSteps.class);

	@EnvReference
	public IBehaviourEnv env = null;

	@Given("set property $property to $value")
	public void setProperty(String property, String value) {
		logger.info("System set property [" + property + "] to [" + value + "]");
		System.setProperty(property, value);
	}

	@Given("print object $value")
	public Object print(Object value) {
		logger.info("Print [" + value.toString() +"]");
		return value;
	}

	@Given("wait for $value second")
	public Integer waitInSecond(Integer value) throws InterruptedException {
		logger.info("Waiting for [" + value.toString() +"] second");
		Thread.sleep(value * 1000);
		return value;
	}

	@Given("wait for $value millisecond")
	public Integer waitInMilisecond(Integer value) throws InterruptedException {
		logger.info("Waiting for [" + value.toString() +"] millisecond");
		Thread.sleep(value);
		return value;
	}

    @Then("store last result as $reference")
    public Object storeReference(String reference) {
    	logger.info("Store as " + reference);
    	return env.store(reference, env.getObject("result"));
    }

    @Then("store last result in file $filename")
    public void storeFile(String filename) throws IOException {
    	logger.info("Store in file " + filename + " / " + env.getObject("result"));
    	FileWriter myFile = new FileWriter(filename);
    	myFile.write(env.getObject("result")+"");
    	myFile.close();
    }

	@Then("return $value")
	public boolean returnResult(String value) {
		logger.info("Return [" + value.toString() +"]");
		if("true".compareTo(value.toLowerCase())==0) return true;
		return false;
	}

	@Then("throw $exception")
	public boolean throwAnException(String value) throws Exception {
		logger.info("Throw [" + value.toString() +"]");
		throw new Exception(value);
	}
}
