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

import java.lang.reflect.InvocationTargetException;

/**
 * this interface describe a comme object to evaluate a java
 * call statement (simple ... not so complex as Velocity engine)
 */
public interface IKeywordCall {
	/**
	 * detect some identifer
	 * @param value
	 * @return 
	 */
	public IKeywordCallElement someIdentifier(String value);
	/**
	 * detect some argument
	 * @param value
	 */
	public void someString(String string);
	/**
	 * detect some Integer
	 * @param integer
	 */
	public void someNumber(Integer integer);
	/**
	 * detect some Double
	 * @param d
	 */
	public void someNumber(Double d);
	/**
	 * detect some number as int
	 * @param d
	 */
	public void someNumber(int d);
	/**
	 * get element by index
	 * @param index
	 * @return
	 */
	public IKeywordCallElement getElement(int index);
	/**
	 * get identifier
	 * - a method with brace
	 * - a simple member
	 * @return
	 */
	public String getIdentifier();
	/**
	 * core of this module, evaluate the expression
	 * @param object
	 * @param index
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 */
	public Object evaluate(Object object, int index) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException;
}
