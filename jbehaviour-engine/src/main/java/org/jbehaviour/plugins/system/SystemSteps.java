package org.jbehaviour.plugins.system;

import org.jbehaviour.annotation.Given;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SystemSteps {
	Logger logger = LoggerFactory.getLogger(SystemSteps.class);
	
	@Given("set property $property to $value")
	public void setProperty(String property, String value) {
		logger.debug("System set property " + property + " to " + value);
		System.setProperty(property, value);
	}

	@Given("print object $value")
	public Object print(Object value) {
		logger.info("Print " + value.toString());
		return value;
	}

}
