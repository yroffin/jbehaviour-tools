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
