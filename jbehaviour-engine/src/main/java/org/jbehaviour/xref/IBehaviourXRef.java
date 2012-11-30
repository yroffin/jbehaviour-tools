package org.jbehaviour.xref;

import java.io.File;
import java.util.Map;

public interface IBehaviourXRef {
	/**
	 * start counter
	 * @return
	 */
	public Long start();
	/**
	 * retrieve run sort by scenario
	 * @return
	 */
	public Map<String, IBehaviourXRefSuite> getRunsByScenario();
	/**
	 * stop counter for this run, and store in session
	 * @param begin
	 * @param pck
	 * @param klass
	 * @param name
	 * @param object
	 * @param args
	 * @param text
	 * @param excp 
	 * @param result 
	 * @param stderr 
	 * @param stdout 
	 * @return
	 */
	public Long stop(String pck, Long begin, String klass, String name, Object object, Object[] args, String text, File stdout, File stderr, Object result, Exception excp);
	
	/**
	 * release all ressources taken during step
	 * invocation
	 */
	public void release();

	/**
	 * get all step disabled
	 * @return
	 */
	public int getDisabled();
	/**
	 * get all step in error
	 * @return
	 */
	public int getErrors();
	/**
	 * get all step in failure
	 * @return
	 */
	public int getFailures();
	/**
	 * get name
	 * @return
	 */
	public String getName();
	/**
	 * setName
	 * @param name
	 */
	void setName(String name);
	/**
	 * get all step (counter)
	 * @return
	 */
	public int getTests();
	/**
	 * get all global time
	 * @return
	 */
	public long getTime();
}
