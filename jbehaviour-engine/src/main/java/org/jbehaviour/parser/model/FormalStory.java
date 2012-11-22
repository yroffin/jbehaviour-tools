package org.jbehaviour.parser.model;

import java.util.ArrayList;
import java.util.List;

import org.jbehaviour.parser.model.impl.KeywordFeature;
import org.jbehaviour.parser.model.impl.KeywordScenario;

public class FormalStory {
	
	KeywordFeature feature = new KeywordFeature();
	List<KeywordScenario> scenarios = new ArrayList<KeywordScenario>();

	public List<KeywordScenario> getScenarios() {
		return scenarios;
	}
	
	public KeywordScenario addScenario() {
		KeywordScenario obj = new KeywordScenario();
		scenarios.add(obj);
		return obj;
	}

	public KeywordFeature getFeature() {
		return feature;
	}

	@Override
	public String toString() {
		return "FormalStory [feature=" + feature + ", scenarios=" + scenarios
				+ "]";
	}
}
