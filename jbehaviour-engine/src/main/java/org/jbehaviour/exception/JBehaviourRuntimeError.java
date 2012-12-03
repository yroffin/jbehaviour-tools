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

package org.jbehaviour.exception;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.antlr.runtime.RecognitionException;

public class JBehaviourRuntimeError extends Exception {

	/**
	 * default serial id
	 */
	private static final long serialVersionUID = 4322248954939295684L;

	public JBehaviourRuntimeError(String message) {
		super(message);
	}

	public JBehaviourRuntimeError(RecognitionException e) {
		super(e);
	}

	public JBehaviourRuntimeError(IOException e) {
		super(e);
	}

	public JBehaviourRuntimeError(InstantiationException e) {
		super(e);
	}

	public JBehaviourRuntimeError(IllegalAccessException e) {
		super(e);
	}

	public JBehaviourRuntimeError(ClassNotFoundException e) {
		super(e);
	}

	public JBehaviourRuntimeError(IllegalArgumentException e) {
		super(e);
	}

	public JBehaviourRuntimeError(InvocationTargetException e) {
		super(e);
	}

	public JBehaviourRuntimeError(Exception e) {
		super(e);
	}

}
