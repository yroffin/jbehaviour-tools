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

import org.antlr.runtime.RecognitionException;

public class JBehaviourParsingError extends Exception {

	/**
	 * default serial id
	 */
	private static final long serialVersionUID = 4322248954939295684L;

	public JBehaviourParsingError(String message) {
		super(message);
	}

	public JBehaviourParsingError(RecognitionException e) {
		super(e);
	}

	public JBehaviourParsingError(ClassNotFoundException e) {
		super(e);
	}

	public JBehaviourParsingError(IOException e) {
		super(e);
	}

	public JBehaviourParsingError(InstantiationException e) {
		super(e);
	}

	public JBehaviourParsingError(IllegalAccessException e) {
		super(e);
	}

}
