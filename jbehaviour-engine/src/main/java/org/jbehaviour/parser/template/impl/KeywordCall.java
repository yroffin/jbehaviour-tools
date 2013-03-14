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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.jbehaviour.parser.template.IKeywordCall;
import org.jbehaviour.parser.template.IKeywordCallElement;

public class KeywordCall implements IKeywordCall {

	private List<IKeywordCallElement> identifiers = new ArrayList<IKeywordCallElement>();
	private IKeywordCallElement current;
	private String identifier;
	
	public KeywordCall(String name) {
		identifier = name.substring(1);
	}

	@Override
	public IKeywordCallElement someIdentifier(String value) {
		current = new KeywordCallElement(value);
		identifiers.add(current);
		return current;
	}

	@Override
	public void someString(String string) {
		current.add(string);
	}

	@Override
	public void someNumber(Integer integer) {
		current.add(integer);
	}

	@Override
	public void someNumber(Double d) {
		current.add(d);
	}

	@Override
	public void someNumber(int d) {
		current.add(d);
	}

	@Override
	public IKeywordCallElement getElement(int index) {
		return identifiers.get(index);
	}

	@Override
	public String toString() {
		return "KeywordCall [identifier=" + identifier + ", identifiers="
				+ identifiers + ", current=" + current + "]";
	}

	@Override
	public String getIdentifier() {
		return identifier;
	}

	@Override
	public Object evaluate(Object object, int index) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException {
		if(index == (identifiers.size())) {
			/**
			 * on last element we can abort
			 * the recursion
			 */
			return object;
		} else {
			/**
			 * not on the last so we have to
			 * recurse on next element
			 */
			IKeywordCallElement item = identifiers.get(index);
			if(item.isMethod()) {
				Object result = null;
				Object[] args = item.toArray();
				if(args.length == 0) {
					result = object.getClass().getMethod(item.getValue()).invoke(object, item.toArray());
				} else {
					/**
					 * find the good one
					 */
					for(Method method : object.getClass().getMethods()) {
						if(method.getName().compareTo(item.getValue()) == 0) {
							result = method.invoke(object, item.toArray());
						}
					}
				}
				return evaluate(result, index+1);
			} else {
				Object result = object.getClass().getField(item.getValue()).get(object);
				return evaluate(result, index+1);
			}
		}
	}
}
