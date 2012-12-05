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
import org.jbehaviour.antlr.AnotherStoryGrammerParser;
import org.jbehaviour.exception.JBehaviourParsingError;
import org.jbehaviour.parser.model.IKeywordStatement;
import org.jbehaviour.parser.model.impl.KeywordAny;

public class JBehaviourStatementParser extends AnotherStoryGrammerParser {
	Logger logger = LoggerFactory.getLogger(JBehaviourStatementParser.class);

	JBehahiourLexer lexer;
	
	public JBehaviourStatementParser(String data) throws JBehaviourParsingError {
		super(JBehahiourLexer.getTokensFromString(data));
		lexer = (JBehahiourLexer) input.getTokenSource();
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

	private IKeywordStatement current = new KeywordAny();

	@Override
	public void onDebug(String where, String value) {
		if(logger.isDebugEnabled()) logger.debug(where + " [" + value + "]");
	}

	@Override
	public void onAnyNumeric(String value) {
		super.onAnyNumeric(value);
		if(current != null) {
			if(logger.isDebugEnabled()) logger.debug("on "+current.getType()+" any integer: " + value);
			current.someInteger(value);
		} else {
			logger.error("Internal error");
		}
	}

	@Override
	public void onAnyString(String value) {
		super.onAnyString(value);
		if(logger.isDebugEnabled()) logger.debug("on scenario/any string: " + value);
		current.someString(value);
	}

	@Override
	public void onAnyIdentifier(String value) {
		super.onAnyIdentifier(value);
		logger.debug("on scenario/any identifier: " + value);
		current.someIdentifier(value);
	}

	@Override
	public void onAnyReference(String value) {
		super.onAnyReference(value);
		logger.debug("on scenario/any reference: " + value);
		current.someReference(value);
	}

	@Override
	public void onAnyTemplate(String value) {
		super.onAnyTemplate(value);
		logger.debug("on scenario/any template: " + value);
		current.someTemplate(value);
	}

	@Override
	public void onAnyJsonObject(String value) {
		super.onAnyJsonObject(value);
		if(current != null) {
			if(logger.isDebugEnabled()) logger.debug("on "+current.getType()+" any json: " + value);
			current.someJson(value);
		} else {
			logger.error("Internal error");
		}
	}

	public IKeywordStatement parse() throws JBehaviourParsingError {
		try {
			error = 0;
			lexer.setError(0);
			anyDecl();
			if(lexer.getError()>0) throw new JBehaviourParsingError("This story has lexer errors");
			if(error>0) throw new JBehaviourParsingError("This statement has errors");
			return current;
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		return null;
	}
}
