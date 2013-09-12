package org.jbehaviour.impl;

import java.util.ArrayList;
import java.util.List;

import org.jbehaviour.IBehaviourScenario;
import org.jbehaviour.parser.model.IKeywordStatement.statement;
import org.jbehaviour.parser.model.impl.KeywordScenario;
import org.jbehaviour.reflexion.IBehaviourReflexionContext;

public class JBehaviourScenario implements IBehaviourScenario {
	private List<IBehaviourReflexionContext> contexts = new ArrayList<IBehaviourReflexionContext>();
	List<IBehaviourScenario> callers = new ArrayList<IBehaviourScenario>();;
	private KeywordScenario parsedScenario;

	public JBehaviourScenario(KeywordScenario _parsedScenario) {
		parsedScenario = _parsedScenario;
	}

	@Override
	public List<IBehaviourReflexionContext> getContexts() {
		return contexts;
	}

	@Override
	public void add(IBehaviourReflexionContext context) {
		contexts.add(context);		
	}

	@Override
	public String getStatement() {
		return parsedScenario.getStatement();
	}

	@Override
	public void setCallers(List<IBehaviourScenario> scenarios) {
		for(IBehaviourScenario scenario : scenarios) {
			for(IBehaviourReflexionContext context : scenario.getContexts()) {
				if(context.getType() == statement.Call && context.getStatement().contains(getStatement())) {
					callers.add(scenario);
				}
			}
		}
	}

	@Override
	public List<IBehaviourScenario> getCallers() {
		return callers;
	}

	@Override
	public int compareTo(IBehaviourScenario o) {
		return getStatement().compareTo(o.getStatement());
	}

	@Override
	public String toString() {
		return "JBehaviourScenario [getStatement()=" + getStatement() + "]";
	}

}
