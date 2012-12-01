package org.jbehaviour.plugins.remote;

import java.io.IOException;
import java.util.List;

import org.jbehaviour.plugins.remote.impl.ResourcesItem;

public interface IFileSystemResource {
	public void open() throws IOException;
	public void close() throws IOException;
	public void setUrl(String url);
	
	/**
	 * behaviour method
	 * check if file exist on this resource
	 * @return
	 * @throws IOException 
	 */
	public boolean checkIfFileExist(String filename) throws IOException;
	
	/**
	 * list local or remote resources
	 * @param directory
	 * @return
	 * @throws IOException
	 */
	public List<ResourcesItem> listdir(String directory) throws IOException;
	
	/**
	 * execute local or remote commande
	 * @param command
	 * @return
	 * @throws IOException 
	 */
	public List<String> execute(String command) throws IOException;
}
