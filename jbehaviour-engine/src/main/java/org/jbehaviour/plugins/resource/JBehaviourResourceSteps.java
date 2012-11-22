package org.jbehaviour.plugins.resource;

import java.io.IOException;
import java.net.MalformedURLException;

import org.jbehaviour.annotation.Given;
import org.jbehaviour.annotation.Then;
import org.jbehaviour.annotation.When;
import org.junit.Assert;

public class JBehaviourResourceSteps {
	/**
	 * all external resources are managed by FileSystemResources
	 * create a new one
	 * @param url
	 * @param resource
	 * @throws MalformedURLException 
	 */
    @Given("create $type resource '$url' identified by '$resource'")
    public void createNewResource(String type, String url, String resource) throws MalformedURLException {
    	FileSystemResources.store(resource,type,url);
    }
    
    @When("open resource '$resource'")
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
    @Then("check if '$file' exist on '$resource'")
    public void checkIfFileExistOnResource(String file, String resource) throws IOException {
    	Assert.assertTrue(FileSystemResources.get(resource).checkIfFileExist(file));
    }
}
