package org.jbehaviour.plugins.system;

import org.jbehaviour.annotation.Given;
import org.jbehaviour.annotation.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SystemSteps {
	Logger logger = LoggerFactory.getLogger(SystemSteps.class);
	
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
