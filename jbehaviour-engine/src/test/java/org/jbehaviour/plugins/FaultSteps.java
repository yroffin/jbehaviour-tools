package org.jbehaviour.plugins;

import org.jbehaviour.annotation.Given;

public class FaultSteps {

	@Given("some message to throw $message")
	public void someFaultingMethod(String message) throws Exception {
		throw new Exception(message);
	}
}
