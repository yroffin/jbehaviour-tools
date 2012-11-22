package org.jbehaviour.plugins;

import org.jbehaviour.annotation.Given;
import org.jbehaviour.annotation.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ComplexSteps {
	Logger logger = LoggerFactory.getLogger(ComplexSteps.class);

	/**
	 * basic steps
	 * @return 
	 */
	@Given("some precondition with complex object return")
	public ComplexBean returnAComplexObject() {
		ComplexBean result = new ComplexBean();
		logger.debug("returnAComplexObject: " + result);
		return result;
	}

	/**
	 * basic steps
	 * @return 
	 */
	@Then("some condition with my bean $myBean")
	public boolean workOnAComplexObject(ComplexBean myBean) {
		logger.debug("workOnAComplexObject: " + myBean);
		return myBean != null;
	}
}
