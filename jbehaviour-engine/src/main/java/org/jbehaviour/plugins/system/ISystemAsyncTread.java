package org.jbehaviour.plugins.system;

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
	 * @throws InterruptedException
	 */
	public void waitFor() throws InterruptedException;
	List<String> getStdoutAsList();
	List<String> getStderrAsList();

}
