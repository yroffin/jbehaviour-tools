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
