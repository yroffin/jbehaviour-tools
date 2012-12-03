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

package org.jbehaviour.plugins.remote;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.jbehaviour.annotation.Given;
import org.jbehaviour.annotation.Then;
import org.jbehaviour.annotation.When;
import org.jbehaviour.plugins.remote.impl.ResourcesItem;

public class JBehaviourRemoteSteps {
	/**
	 * all external resources are managed by FileSystemResources
	 * create a new one
	 * @param url
	 * @param resource
	 * @throws MalformedURLException 
	 */
    @Given("with remote create $type resource $url identified by $resource")
    public void createNewResource(String type, String url, String resource) throws MalformedURLException {
    	FileSystemResources.store(resource,type,url);
    }
    
    @When("with remote open resource '$resource'")
    public void openResource(String resource) throws IOException {
    	IFileSystemResource myResource = FileSystemResources.get(resource);
    	myResource.open();
    }

    /**
     * check for file existence
     * @param file
     * @param resource
     * @throws IOException 
     */
    @Then("with remote check if $file exist on $resource")
    public boolean checkIfFileExistOnResource(String file, String resource) throws IOException {
    	IFileSystemResource myResource = FileSystemResources.get(resource);
    	return myResource.checkIfFileExist(file) == true;
    }

    /**
     * list remote dir
     * @param directory
     * @param resource
     * @return
     * @throws IOException
     */
    @Given("with remote list directory $directory on $resource")
    public List<ResourcesItem> listDirectory(String directory, String resource) throws IOException {
    	IFileSystemResource myResource = FileSystemResources.get(resource);
    	return myResource.listdir(directory);
    }

    /**
     * execute remote command
     * @param command
     * @param resource
     * @return
     * @throws IOException
     */
    @Given("with remote execute command $command on $resource")
    public List<String> executeCommand(String command, String resource) throws IOException {
    	IFileSystemResource myResource = FileSystemResources.get(resource);
    	return myResource.execute(command);
    }
}
