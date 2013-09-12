package org.jbehaviour;

import java.util.List;

import org.jbehaviour.reflexion.IBehaviourReflexionContext;

public interface IBehaviourScenario extends Comparable<IBehaviourScenario> {
	/**
	 * add a new compiled context to this scenario
	 * @param context
	 */
	public void add(IBehaviourReflexionContext context);
	/**
	 * get all context
	 * @return
	 */
	public List<IBehaviourReflexionContext> getContexts();
	/**
	 * get the statement of this scenario
	 * @return
	 */
	public String getStatement();
	/**
	 * compute which scenario call this one
	 * @param scenarios
	 */
	public void setCallers(List<IBehaviourScenario> scenarios);
	/**
	 * retrieve scenario which call this one
	 * @return
	 */
	public List<IBehaviourScenario> getCallers();
}
