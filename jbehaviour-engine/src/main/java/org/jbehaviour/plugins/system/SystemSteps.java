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
import java.util.ArrayList;
import java.util.List;

import org.jbehaviour.annotation.Call;
import org.jbehaviour.annotation.EnvReference;
import org.jbehaviour.annotation.Given;
import org.jbehaviour.annotation.Then;
import org.jbehaviour.exception.JBehaviourRuntimeError;
import org.jbehaviour.plugins.system.impl.SystemAsyncThread;
import org.jbehaviour.reflexion.IBehaviourEnv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SystemSteps {
	Logger logger = LoggerFactory.getLogger(SystemSteps.class);

	@EnvReference
	public IBehaviourEnv env = null;

	@Given("start $command with $args as $reference")
	public ISystemAsyncTread startCommandWithArgsAsReference(String command, String args, String reference) throws InterruptedException {
		logger.info("Start [" + command + "] with [" + args + "] as [" + reference + "]");
		List<String> arguments = new ArrayList<String>();
		arguments.add(command);
		for(String item : args.split(" ")) {
			arguments.add(item);
		}
		ISystemAsyncTread localThread = new SystemAsyncThread(arguments);
		env.store(reference, localThread);
		localThread.start();
		
		while(!localThread.ready()) {
			Thread.sleep(100);
		}
		return localThread;
	}

	@Given("send return to async command $reference")
	public ISystemAsyncTread sendReturnToAsyncCommandReference(ISystemAsyncTread localThread) throws InterruptedException, JBehaviourRuntimeError, IOException {
		if(localThread == null) {
			throw new JBehaviourRuntimeError("Reference is null");
		}
		localThread.write("\n");
		return localThread;
	}

	@Given("wait for async command $reference")
	public ISystemAsyncTread waitForAsyncCommandReference(ISystemAsyncTread localThread) throws InterruptedException, JBehaviourRuntimeError {
		if(localThread == null) {
			throw new JBehaviourRuntimeError("Reference is null");
		}
		localThread.waitFor();
		return localThread;
	}

	@Given("set property $property to $value")
	public void setProperty(String property, String value) {
		logger.info("System set property [" + property + "] to [" + value + "]");
		System.setProperty(property, value);
	}

	@Given("print object $value")
	public Object print(Object value) {
		if(value != null) {
			System.out.println("\n" + "[" + value.toString() +"]");
		} else {
			System.out.println("\n" + "[" + value +"]");
		}
		return value;
	}

	@Given("wait for $value seconds")
	public Integer waitInSecond(Integer value) throws InterruptedException {
		logger.info("Waiting for [" + value.toString() +"] second");
		Thread.sleep(value * 1000);
		return value;
	}

	@Given("wait for $value milliseconds")
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

	@Call("foreach $list as $item call $scenario")
	public void foreach(List<?> list, String reference, String scenario) throws JBehaviourRuntimeError {
		for(Object obj : list) {
			System.out.println("Foreach [" + obj + "] => $" + reference);
			/**
			 * use launcher to execute our scenario
			 */
			env.store(reference, obj);
			env.getLauncher().executeByStatement(scenario);
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
