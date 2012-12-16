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

package org.jbehaviour.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.antlr.runtime.RecognitionException;
import org.jbehaviour.antlr.AnotherMethodGrammerParser;
import org.jbehaviour.exception.JBehaviourParsingError;
import org.jbehaviour.parser.template.IKeywordCall;
import org.jbehaviour.parser.template.IKeywordCallElement;
import org.jbehaviour.parser.template.impl.KeywordCall;

public class JBehaviourCallParser extends AnotherMethodGrammerParser {
	Logger logger = LoggerFactory.getLogger(JBehaviourCallParser.class);

	JBehahiourCallLexer lexer;
	
	public JBehaviourCallParser(String data) throws JBehaviourParsingError {
		super(JBehahiourCallLexer.getTokensFromString(data));
		lexer = (JBehahiourCallLexer) input.getTokenSource();
	}

	int error = 0;
	@Override
	public void emitErrorMessage(String msg) {
		logger.error(msg);
		error++;
	}

	@Override
	public void traceIn(String ruleName, int ruleIndex) {
		if(logger.isDebugEnabled()) {
			StringBuilder sb = new StringBuilder();
			sb.append("enter "+ruleName+" "+input.LT(1));
			if ( state.backtracking>0 ) {
				sb.append(" backtracking="+state.backtracking);
			}
			logger.debug(sb.toString());
		}
	}

	@Override
	public void traceOut(String ruleName, int ruleIndex) {
		if(logger.isDebugEnabled()) {
			StringBuilder sb = new StringBuilder();
			sb.append("exit "+ruleName+" "+input.LT(1));
			if ( state.backtracking>0 ) {
				sb.append(" backtracking="+state.backtracking);
	            if ( state.failed ) sb.append(" failed");
	            else sb.append(" succeeded");
	        }
			logger.debug(sb.toString());
		}
	}

	@Override
	public void onDebug(String where, String value) {
		if(logger.isDebugEnabled()) logger.debug(where + " [" + value + "]");
	}

	private IKeywordCall current = null;
	private IKeywordCallElement call;

	@Override
	public void onAnyReference(String reference) {
		super.onAnyReference(reference);
		current = new KeywordCall(reference);
	}

	@Override
	public void onAnyIdentifier(String identifier) {
		super.onAnyIdentifier(identifier);
		call = current.someIdentifier(identifier);
	}

	@Override
	public void onIsMethod(String isMethod) {
		super.onIsMethod(isMethod);
		call.setMethod("(".compareTo(isMethod)==0);
	}

	@Override
	public void onAnyString(String string) {
		super.onAnyString(string);
		current.someString(string.substring(1,string.length()-1));
	}

	@Override
	public void onAnyNumber(String number) {
		super.onAnyNumber(number);
		if(number.contains(".")) {
			current.someNumber(new Double(number));
		} else {
			current.someNumber(new Integer(number));
		}
	}

	public IKeywordCall parse() throws JBehaviourParsingError {
		try {
			error = 0;
			lexer.setError(0);
			template();
			if(lexer.getError()>0) throw new JBehaviourParsingError("This story has lexer errors");
			if(error>0) throw new JBehaviourParsingError("This statement has errors");
			return current;
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		return null;
	}
}
