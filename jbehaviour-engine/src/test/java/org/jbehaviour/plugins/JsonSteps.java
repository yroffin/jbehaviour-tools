package org.jbehaviour.plugins;

import org.jbehaviour.annotation.Given;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonSteps {
	Logger logger = LoggerFactory.getLogger(JsonSteps.class);

	/**
	 * basic steps
	 * @return 
	 */
	@Given("some json as $bean")
	public ComplexJsonBean validateJson(ComplexJsonBean obj) {
		logger.debug("validateJson:" + obj);
		return obj;
	}
}
