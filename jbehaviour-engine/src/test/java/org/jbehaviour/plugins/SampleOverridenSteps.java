package org.jbehaviour.plugins;

import org.jbehaviour.annotation.Given;
import org.jbehaviour.annotation.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SampleOverridenSteps extends SampleSteps {
	protected Logger logger = LoggerFactory.getLogger(SampleOverridenSteps.class);
	/**
	 * basic steps
	 */
	@Override
	@Given("some precondition")
	public void precondition001() {
		logger.debug("precondition001 overriden ...");
		super.precondition001();
	}
	@Override
	@Then("something else we can check happens too")
	public boolean test002() {
		logger.debug("test002 overriden ...");
		return super.test002();
	}
}
