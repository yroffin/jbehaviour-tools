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
