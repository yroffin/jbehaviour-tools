package org.jbehaviour.plugins.system;

import java.io.IOException;
import java.util.List;

public interface ISystemAsyncTread {
	/**
	 * runnning part
	 */
	public void run();
	/**
	 * result of system command
	 * @return
	 */
	public int getResult();
	/**
	 * start thread
	 */
	public void start();
	/**
	 * wait for completion
	 * @return 
	 * @throws InterruptedException
	 */
	public int waitFor() throws InterruptedException;
	List<String> getStdoutAsList();
	List<String> getStderrAsList();
	/**
	 * write some string to stdin
	 * @param string
	 * @throws IOException 
	 */
	public void write(String string) throws IOException;
	public boolean ready();

}
