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
import java.util.Formatter;
import java.util.List;

import org.jbehaviour.annotation.Given;
import org.jbehaviour.annotation.Then;
import org.jbehaviour.annotation.When;

public class JBehaviourRemoteSteps {
	
	private StringBuilder sbFormat = new StringBuilder();
	private Formatter formatter = null;
	private int columnLength = 16;

	public JBehaviourRemoteSteps() {
		formatter = new Formatter(sbFormat);
	}

	/**
	 * all external resources are managed by FileSystemResources
	 * create a new one
	 * @param url
	 * @param resource
	 * @return 
	 * @throws MalformedURLException 
	 */
    @Given("with remote create $type resource $url identified by $resource")
    public IFileSystemResource createNewResource(String type, String url, String resource) throws MalformedURLException {
    	if(url == null) {
    		throw new MalformedURLException("Url cannot be null !!!");
    	}
    	return FileSystemResources.store(resource,type,url);
    }
    
    /**
     * open a remote resource
     * @param resource
     * @throws IOException
     */
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
	 * line formating
	 * @param iCol
	 * @param value
	 * @return
	 */
	private String format(int iCol, String value) {
		sbFormat.setLength(0);
		if(iCol != 0) {
			formatter.format("%-"+columnLength+"."+columnLength+"s |", value);
		} else {
			formatter.format("| %-"+columnLength+"."+columnLength+"s |", value);
		}
		return sbFormat.toString();
	}
	
	/**
	 * header formating
	 * @param iCol
	 * @param value
	 * @return
	 */
	private String formatHeader(int iCol) {
		sbFormat.setLength(0);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<columnLength;i++) sb.append('-');
		if(iCol != 0) {
			formatter.format("%-"+columnLength+"."+columnLength+"s-+", sb.toString());
		} else {
			formatter.format("+-%-"+columnLength+"."+columnLength+"s-+", sb.toString());
		}
		return sbFormat.toString();
	}

	/**
	 * internal method to dump a list to stdout
	 * @param result
	 * @return
	 */
	private String toString(List<IResourcesItem> result) {
		StringBuilder sb = new StringBuilder();
		/**
		 * compute header
		 */
		StringBuilder header = new StringBuilder();
		int iColHeader=0;
		for(;iColHeader<5;) {
			header.append(formatHeader(iColHeader++));
		}
		header.append("\n");

		sb.append("\nRow(s):" + result.size() + "\n");
		sb.append(header);
		int iCol=0;
		sb.append(format(iCol++,"Name"));
		sb.append(format(iCol++,"Long Name"));
		sb.append(format(iCol++,"Size"));
		sb.append(format(iCol++,"Can read"));
		sb.append(format(iCol++,"Can write"));
		sb.append("\n");
		sb.append(header);
		for(IResourcesItem line : result) {
			int iColValue=0;
			sb.append(format(iColValue++,line.getName()));
			sb.append(format(iColValue++,line.getLongName()));
			sb.append(format(iColValue++,line.getSize()+""));
			sb.append(format(iColValue++,line.isCanRead()+""));
			sb.append(format(iColValue++,line.isCanWrite()+""));
			sb.append("\n");
		}
		sb.append(header);
		return sb.toString();
	}

	/**
     * list remote dir
     * @param directory
     * @param resource
     * @return
     * @throws IOException
     */
    @Given("with remote list directory $directory on $resource")
    public List<IResourcesItem> listDirectory(String directory, String resource) throws IOException {
    	IFileSystemResource myResource = FileSystemResources.get(resource);
    	List<IResourcesItem> result = myResource.listdir(directory);
    	System.out.println(toString(result));
    	return result;
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

    /**
     * put to remote
     * @param input
     * @param output
     * @param resource
     * @return
     * @throws IOException
     */
    @When("with remote put $input to $output on $resource")
    public List<IResourcesItem> putOnRemote(String input, String output, String resource) throws IOException {
    	IFileSystemResource myResource = FileSystemResources.get(resource);
    	return myResource.put(input, output);
    }

    /**
     * get from remote
     * @param input
     * @param output
     * @param resource
     * @return
     * @throws IOException
     */
    @When("with remote put $input to $output on $resource")
    public List<IResourcesItem> getFromRemote(String input, String output, String resource) throws IOException {
    	IFileSystemResource myResource = FileSystemResources.get(resource);
    	return myResource.put(input, output);
    }
}
