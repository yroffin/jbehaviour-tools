/**
 *  Copyright 2012 Yannick Roffin
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package org.jbehaviour.plugins;

import org.jbehaviour.annotation.Given;
import org.jbehaviour.annotation.Then;
import org.jbehaviour.annotation.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SampleSteps {
	Logger logger = LoggerFactory.getLogger(SampleSteps.class);

	/**
	 * basic steps
	 */
	@Given("some precondition")
	public void precondition001() {
		logger.debug("precondition001");
	}
	@Given("some other precondition")
	public void precondition002() {
		logger.debug("precondition002");
	}
	@When("some action by the actor")
	public void action001() {
		logger.debug("action001");
	}
	@When("some other action")
	public void action002() {
		logger.debug("action002");
	}
	@When("yet another action")
	public void action003() {
		logger.debug("action003");
	}
	@Then("some testable outcome is achieved")
	public boolean test001() {
		logger.debug("test001");
		return true;
	}
	@Then("something else we can check happens too")
	public boolean test002() {
		logger.debug("test002");
		return true;
	}
	/**
	 * parametrable steps
	 */
	@Given("some precondition with one $parameter")
	public void preconditionPrm001(String parameter) {
		logger.debug("preconditionPrm001: " + parameter);
	}
	@Given("some precondition with int $parameter")
	public void preconditionPrm002(int parameter) {
		logger.debug("preconditionPrm002: " + (parameter + 10));
	}
	/**
	 * parametrable steps
	 */
	@Given("multiply $a by $b")
	public int preconditionPrm003(int a, int b) {
		logger.debug("preconditionPrm003: " + a + "*" + b + "=" + (a*b));
		return a * b;
	}
	/**
	 * with argment
	 * @param argument
	 */
	@Given("some precondition with $argument")
	public void precondition000(String argument) {
		logger.debug("precondition000 overriden ... " + argument);
	}
}
