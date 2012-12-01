package org.jbehaviour.parser;

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

	JBehahiourLexer lexer;
	public JBehaviourParser(String filename) throws JBehaviourParsingError {
		super(JBehahiourLexer.getTokens(filename));
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

	private FormalStory story;
	private KeywordScenario scenario = null;
	private IKeywordStatement current = null;

	@Override
	public void onAnyString(String value) {
		if(logger.isDebugEnabled()) super.onAnyString(value);
		if(current != null) {
			logger.debug("on "+current.getType()+" any string: " + value);
			current.someString(value);
		} else {
			logger.error("Internal error");
		}
	}

	@Override
	public void onAnyNumeric(String value) {
		if(logger.isDebugEnabled()) super.onAnyNumeric(value);
		if(current != null) {
			logger.debug("on "+current.getType()+" any integer: " + value);
			current.someInteger(value);
		} else {
			logger.error("Internal error");
		}
	}

	@Override
	public void onAnyIdentifier(String value) {
		if(logger.isDebugEnabled()) super.onAnyIdentifier(value);
		if(current != null) {
			logger.debug("on "+current.getType()+" any identifier: " + value);
			current.someIdentifier(value);
		} else {
			logger.error("Internal error");
		}
	}

	@Override
	public void onAnyReference(String value) {
		if(logger.isDebugEnabled()) super.onAnyReference(value);
		if(current != null) {
			logger.debug("on "+current.getType()+" any reference: " + value);
			current.someReference(value);
		} else {
			logger.error("Internal error");
		}
	}

	@Override
	public void onAnyTemplate(String value) {
		if(logger.isDebugEnabled()) super.onAnyTemplate(value);
		if(current != null) {
			logger.debug("on "+current.getType()+" any template: " + value);
			current.someTemplate(value);
		} else {
			logger.error("Internal error");
		}
	}

	@Override
	public void onAnyJsonObject(String value) {
		if(logger.isDebugEnabled()) super.onAnyJsonObject(value);
		if(current != null) {
			logger.debug("on "+current.getType()+" any json: " + value);
			current.someJson(value);
		} else {
			logger.error("Internal error");
		}
	}

	@Override
	public void onFeatureKeyword() {
		if(logger.isDebugEnabled()) super.onFeatureRegisterKeyword();
		logger.debug("on feature");
		current = story.getFeature();
	}

	@Override
	public void onFeatureIncludeKeyword() {
		if(logger.isDebugEnabled()) super.onFeatureIncludeKeyword();
		logger.debug("on feature/include");
		current = story.getFeature().addIncludeStatement();
	}

	@Override
	public void onFeatureRegisterKeyword() {
		if(logger.isDebugEnabled()) super.onFeatureRegisterKeyword();
		logger.debug("on feature/register");
		current = story.getFeature().addRegisterStatement();
	}

	@Override
	public void onFeatureReportKeyword() {
		if(logger.isDebugEnabled()) super.onFeatureReportKeyword();
		logger.debug("on feature/report");
		current = story.getFeature().addReportStatement();
	}

	@Override
	public void onFeatureDeclareKeyword() {
		if(logger.isDebugEnabled()) super.onFeatureDeclareKeyword();
		logger.debug("on feature/declare");
		current = story.getFeature().addDeclareStatement();
	}

	@Override
	public void onScenarioKeyword() {
		if(logger.isDebugEnabled()) super.onScenarioKeyword();
		logger.debug("on scenario");
		scenario = story.addScenario();
		current = scenario;
	}

	@Override
	public void onGivenKeyword() {
		if(logger.isDebugEnabled()) super.onGivenKeyword();
		logger.debug("on scenario/given");
		current = scenario.addGivenStatement();
	}

	@Override
	public void onWhenKeyword() {
		if(logger.isDebugEnabled()) super.onWhenKeyword();
		logger.debug("on scenario/when");
		current = scenario.addWhenStatement();
	}

	@Override
	public void onThenKeyword() {
		if(logger.isDebugEnabled()) super.onThenKeyword();
		logger.debug("on scenario/then");
		current = scenario.addThenStatement();
	}

	@Override
	public void onStoreKeyword() {
		if(logger.isDebugEnabled()) super.onStoreKeyword();
		logger.debug("on scenario/store");
		current = scenario.addStoreStatement();
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
