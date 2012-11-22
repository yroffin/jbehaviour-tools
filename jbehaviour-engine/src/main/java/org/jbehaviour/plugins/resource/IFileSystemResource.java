package org.jbehaviour.plugins.resource;

import java.io.IOException;

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
}
