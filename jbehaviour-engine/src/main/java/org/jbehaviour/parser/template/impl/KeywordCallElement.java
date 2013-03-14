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

package org.jbehaviour.parser.template.impl;

import java.util.ArrayList;
import java.util.List;

import org.jbehaviour.parser.template.IKeywordCallElement;

public class KeywordCallElement implements IKeywordCallElement {

	private List<Object> arguments = new ArrayList<Object>();
	private String value;
	private boolean isMethod = false;
	
	public KeywordCallElement(String value) {
		this.value = value;
	}

	@Override
	public Object[] toArray() {
		return arguments.toArray();		
	}

	@Override
	public void add(String value) {
		arguments.add(value);		
	}

	@Override
	public void add(Double value) {
		arguments.add(value);		
	}

	@Override
	public void add(Integer integer) {
		arguments.add(integer);		
	}

	@Override
	public void add(int integer) {
		arguments.add(integer);		
	}

	@Override
	public String toString() {
		return "KeywordCallElement [value=" + value + ", arguments="
				+ arguments + "]";
	}

	@Override
	public String getValue() {
		return value;
	}
	
	@Override
	public boolean isMethod() {
		return isMethod ;
	}

	@Override
	public void setMethod(boolean isMethod) {
		this.isMethod = isMethod;
	}
}
