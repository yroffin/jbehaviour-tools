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

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.antlr.runtime.RecognitionException;
import org.jbehaviour.antlr.AnotherStoryGrammerParser;
import org.jbehaviour.exception.JBehaviourParsingError;
import org.jbehaviour.parser.model.FormalStory;
import org.jbehaviour.parser.model.IKeywordStatement;
import org.jbehaviour.parser.model.impl.KeywordScenario;

public class JBehaviourParser extends AnotherStoryGrammerParser {
	Logger logger = LoggerFactory.getLogger(JBehaviourParser.class);

	JBehahiourStoryLexer lexer;
	public JBehaviourParser(File filename) throws JBehaviourParsingError {
		super(JBehahiourStoryLexer.getTokens(filename.getAbsolutePath()));
		lexer = (JBehahiourStoryLexer) input.getTokenSource();
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

	private FormalStory story;
	private KeywordScenario scenario = null;
	private IKeywordStatement current = null;

	@Override
	public void onDebug(String where, String value) {
		if(logger.isDebugEnabled()) {
			logger.debug(where + " [" + value + "]");
		}
	}

	@Override
	public void onAnyString(String value) {
		super.onAnyString(value);
		if(current != null) {
			if(logger.isDebugEnabled()) {
				logger.debug("on "+current.getType()+" any string: " + value);
			}
			current.someString(value);
		} else {
			logger.error("Internal error");
		}
	}

	@Override
	public void onAnyNumeric(String value) {
		super.onAnyNumeric(value);
		if(current != null) {
			if(logger.isDebugEnabled()) {
				logger.debug("on "+current.getType()+" any integer: " + value);
			}
			current.someInteger(value);
		} else {
			logger.error("Internal error");
		}
	}

	@Override
	public void onAnyIdentifier(String value) {
		super.onAnyIdentifier(value);
		if(current != null) {
			if(logger.isDebugEnabled()) {
				logger.debug("on "+current.getType()+" any identifier: " + value);
			}
			current.someIdentifier(value);
		} else {
			logger.error("Internal error");
		}
	}

	@Override
	public void onAnyReference(String value) {
		super.onAnyReference(value);
		if(current != null) {
			if(logger.isDebugEnabled()) {
				logger.debug("on "+current.getType()+" any reference: " + value);
			}
			current.someReference(value);
		} else {
			logger.error("Internal error");
		}
	}

	@Override
	public void onAnyTemplate(String value) {
		super.onAnyTemplate(value);
		if(current != null) {
			if(logger.isDebugEnabled()) {
				logger.debug("on "+current.getType()+" any template: " + value);
			}
			current.someTemplate(value);
		} else {
			logger.error("Internal error");
		}
	}

	@Override
	public void onAnyJsonObject(String value) {
		super.onAnyJsonObject(value);
		if(current != null) {
			if(logger.isDebugEnabled()) {
				logger.debug("on "+current.getType()+" any json: " + value);
			}
			current.someJson(value);
		} else {
			logger.error("Internal error");
		}
	}

	@Override
	public void onFeatureKeyword() {
		super.onFeatureRegisterKeyword();
		if(logger.isDebugEnabled()) {
			logger.debug("on feature");
		}
		current = story.getFeature();
	}

	@Override
	public void onFeatureIncludeKeyword() {
		super.onFeatureIncludeKeyword();
		if(logger.isDebugEnabled()) {
			logger.debug("on feature/include");
		}
		current = story.getFeature().addIncludeStatement();
	}

	@Override
	public void onFeatureRegisterKeyword() {
		super.onFeatureRegisterKeyword();
		if(logger.isDebugEnabled()) {
			logger.debug("on feature/register");
		}
		current = story.getFeature().addRegisterStatement();
	}

	@Override
	public void onFeatureReportKeyword() {
		super.onFeatureReportKeyword();
		if(logger.isDebugEnabled()) {
			logger.debug("on feature/report");
		}
		current = story.getFeature().addReportStatement();
	}

	@Override
	public void onFeatureDeclareKeyword() {
		super.onFeatureDeclareKeyword();
		if(logger.isDebugEnabled()) {
			logger.debug("on feature/declare");
		}
		current = story.getFeature().addDeclareStatement();
	}

	@Override
	public void onScenarioKeyword() {
		super.onScenarioKeyword();
		if(logger.isDebugEnabled()) {
			logger.debug("on scenario");
		}
		scenario = story.addScenario();
		current = scenario;
	}

	@Override
	public void onGivenKeyword() {
		super.onGivenKeyword();
		if(logger.isDebugEnabled()) {
			logger.debug("on scenario/given");
		}
		current = scenario.addGivenStatement();
	}

	@Override
	public void onWhenKeyword() {
		super.onWhenKeyword();
		if(logger.isDebugEnabled()) {
			logger.debug("on scenario/when");
		}
		current = scenario.addWhenStatement();
	}

	@Override
	public void onThenKeyword() {
		super.onThenKeyword();
		if(logger.isDebugEnabled()) {
			logger.debug("on scenario/then");
		}
		current = scenario.addThenStatement();
	}

	@Override
	public void onCallKeyword() {
		super.onCallKeyword();
		if(logger.isDebugEnabled()) {
			logger.debug("on scenario/call");
		}
		current = scenario.addCallStatement();
	}

	/**
	 * parse this story
	 * @return
	 * @throws JBehaviourParsingError 
	 */
	public FormalStory parse() throws JBehaviourParsingError {
		try {
			error = 0;
			lexer.setError(0);
			story = new FormalStory();
			story();
			if(lexer.getError()>0) throw new JBehaviourParsingError("This story has lexer errors");
			if(error>0) throw new JBehaviourParsingError("This story has parsing errors");
			return story;
		} catch (RecognitionException e) {
			throw new JBehaviourParsingError(e);
		}
	}
}
