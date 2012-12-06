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

package org.jbehaviour.plugins.system;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.jbehaviour.annotation.EnvReference;
import org.jbehaviour.annotation.Given;
import org.jbehaviour.annotation.Then;
import org.jbehaviour.reflexion.IBehaviourEnv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SystemSteps {
	Logger logger = LoggerFactory.getLogger(SystemSteps.class);

	@EnvReference
	public IBehaviourEnv env = null;

	@Given("set property $property to $value")
	public void setProperty(String property, String value) {
		logger.info("System set property [" + property + "] to [" + value + "]");
		System.setProperty(property, value);
	}

	@Given("print object $value")
	public Object print(Object value) {
		System.out.println("\n" + "[" + value.toString() +"]");
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

    @Given("store last result as $reference")
    public Object storeReference(String reference) {
    	logger.info("Store as " + reference);
    	return env.store(reference, env.getObject("result"));
    }

    @Then("store last result in file $filename")
    public boolean storeFile(String filename) throws IOException {
    	logger.info("Store in file " + filename + " / " + env.getObject("result"));
    	FileWriter myFile = new FileWriter(filename);
    	myFile.write(env.getObject("result")+"");
    	myFile.close();
    	return true;
    }

	@Given("foreach $list as $item call $scenario")
	public void foreach(List<?> list, String reference, String scenario) {
		for(Object obj : list) {
			System.out.println("Foreach [" + obj + "]");
		}
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
