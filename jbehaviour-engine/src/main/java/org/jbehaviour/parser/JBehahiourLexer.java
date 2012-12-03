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

import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.jbehaviour.antlr.AnotherStoryGrammerLexer;
import org.jbehaviour.exception.JBehaviourParsingError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JBehahiourLexer extends AnotherStoryGrammerLexer {
	Logger logger = LoggerFactory.getLogger(JBehahiourLexer.class);

	int error = 0;
	public int getError() {
		return error;
	}

	@Override
	public void emitErrorMessage(String msg) {
		logger.error(msg);
		error++;
	}

	@Override
	public void traceIn(String ruleName, int ruleIndex, Object inputSymbol) {
		if(logger.isDebugEnabled()) {
			StringBuilder sb = new StringBuilder();
			sb.append("enter "+ruleName+" "+inputSymbol);
			if ( state.backtracking>0 ) {
				sb.append(" backtracking="+state.backtracking);
			}
			logger.debug(sb.toString());
		}
	}

	@Override
	public void traceOut(String ruleName, int ruleIndex, Object inputSymbol) {
		if(logger.isDebugEnabled()) {
			StringBuilder sb = new StringBuilder();
			sb.append("exit "+ruleName+" "+inputSymbol);
			if ( state.backtracking>0 ) {
				sb.append(" backtracking="+state.backtracking);
	            if ( state.failed ) sb.append(" failed");
	            else sb.append(" succeeded");
	        }
			logger.debug(sb.toString());
		}
	}

	public JBehahiourLexer(ANTLRFileStream antlrFileStream) {
		super(antlrFileStream);
	}

	public JBehahiourLexer(ANTLRStringStream antlrStringStream) {
		super(antlrStringStream);
	}

	protected static CommonTokenStream getTokens(String filename) throws JBehaviourParsingError {
		JBehahiourLexer lexer;
		try {
			lexer = new JBehahiourLexer(
					new ANTLRFileStream(filename,"UTF8"));
		} catch (IOException e) {
			throw new JBehaviourParsingError(e);
		}
		return new CommonTokenStream(lexer);
	}
	
	protected static CommonTokenStream getTokensFromString(String data) throws JBehaviourParsingError {
		JBehahiourLexer lexer = new JBehahiourLexer(new ANTLRStringStream(data));
		return new CommonTokenStream(lexer);
	}

	public void setError(int i) {
		error = i;		
	}

}
