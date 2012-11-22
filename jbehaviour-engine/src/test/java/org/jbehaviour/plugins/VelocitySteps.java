package org.jbehaviour.plugins;

import org.jbehaviour.annotation.Given;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VelocitySteps {
	Logger logger = LoggerFactory.getLogger(VelocitySteps.class);

	/**
	 * basic steps
	 * @return 
	 */
	@Given("some template string as $template")
	public Object validateVelocity(Object obj) {
		logger.debug("validateVelocity:" + obj);
		return obj;
	}
}
