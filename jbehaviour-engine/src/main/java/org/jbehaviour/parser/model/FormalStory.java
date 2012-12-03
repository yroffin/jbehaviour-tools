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
