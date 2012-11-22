package org.jbehaviour.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.antlr.runtime.RecognitionException;
import org.jbehaviour.antlr.AnotherStoryGrammerParser;
import org.jbehaviour.exception.JBehaviourPasingError;
import org.jbehaviour.parser.model.FormalStory;
import org.jbehaviour.parser.model.IKeywordStatement;
import org.jbehaviour.parser.model.impl.KeywordScenario;

public class JBehaviourParser extends AnotherStoryGrammerParser {
	Logger logger = LoggerFactory.getLogger(JBehaviourParser.class);

	JBehahiourLexer lexer;
	public JBehaviourParser(String filename) throws JBehaviourPasingError {
		super(JBehahiourLexer.getTokens(filename));
		lexer = (JBehahiourLexer) input.getTokenSource();
	}

	int error = 0;
	@Override
	public void emitErrorMessage(String msg) {
		logger.error(msg);
		error++;
	}

	private FormalStory story;
	private KeywordScenario scenario = null;
	private IKeywordStatement current = null;

	@Override
	public void onAnyString(String value) {
		super.onAnyString(value);
		if(current != null) {
			logger.debug("on "+current.getType()+" any string: " + value);
			current.someString(value);
		} else {
			logger.error("Internal error");
		}
	}

	@Override
	public void onAnyNumeric(String value) {
		super.onAnyNumeric(value);
		if(current != null) {
			logger.debug("on "+current.getType()+" any integer: " + value);
			current.someInteger(value);
		} else {
			logger.error("Internal error");
		}
	}

	@Override
	public void onAnyIdentifier(String value) {
		super.onAnyIdentifier(value);
		if(current != null) {
			logger.debug("on "+current.getType()+" any identifier: " + value);
			current.someIdentifier(value);
		} else {
			logger.error("Internal error");
		}
	}

	@Override
	public void onAnyReference(String value) {
		super.onAnyReference(value);
		if(current != null) {
			logger.debug("on "+current.getType()+" any reference: " + value);
			current.someReference(value);
		} else {
			logger.error("Internal error");
		}
	}

	@Override
	public void onAnyTemplate(String value) {
		super.onAnyTemplate(value);
		if(current != null) {
			logger.debug("on "+current.getType()+" any template: " + value);
			current.someTemplate(value);
		} else {
			logger.error("Internal error");
		}
	}

	@Override
	public void onAnyJsonObject(String value) {
		super.onAnyJsonObject(value);
		if(current != null) {
			logger.debug("on "+current.getType()+" any json: " + value);
			current.someJson(value);
		} else {
			logger.error("Internal error");
		}
	}

	@Override
	public void onFeatureKeyword() {
		super.onFeatureRegisterKeyword();
		logger.debug("on feature");
		current = story.getFeature();
	}

	@Override
	public void onFeatureIncludeKeyword() {
		super.onFeatureIncludeKeyword();
		logger.debug("on feature/include");
		current = story.getFeature().addIncludeStatement();
	}

	@Override
	public void onFeatureRegisterKeyword() {
		super.onFeatureRegisterKeyword();
		logger.debug("on feature/register");
		current = story.getFeature().addRegisterStatement();
	}

	@Override
	public void onFeatureDeclareKeyword() {
		super.onFeatureDeclareKeyword();
		logger.debug("on feature/declare");
		current = story.getFeature().addDeclareStatement();
	}

	@Override
	public void onScenarioKeyword() {
		super.onScenarioKeyword();
		logger.debug("on scenario");
		scenario = story.addScenario();
		current = scenario;
	}

	@Override
	public void onGivenKeyword() {
		super.onGivenKeyword();
		logger.debug("on scenario/given");
		current = scenario.addGivenStatement();
	}

	@Override
	public void onWhenKeyword() {
		super.onWhenKeyword();
		logger.debug("on scenario/when");
		current = scenario.addWhenStatement();
	}

	@Override
	public void onThenKeyword() {
		super.onThenKeyword();
		logger.debug("on scenario/then");
		current = scenario.addThenStatement();
	}

	@Override
	public void onStoreKeyword() {
		super.onStoreKeyword();
		logger.debug("on scenario/store");
		current = scenario.addStoreStatement();
	}

	/**
	 * parse this story
	 * @return
	 * @throws JBehaviourPasingError 
	 */
	public FormalStory parse() throws JBehaviourPasingError {
		try {
			error = 0;
			lexer.setError(0);
			story = new FormalStory();
			story();
			if(lexer.getError()>0) throw new JBehaviourPasingError("This story has lexer errors");
			if(error>0) throw new JBehaviourPasingError("This story has parsing errors");
			return story;
		} catch (RecognitionException e) {
			throw new JBehaviourPasingError(e);
		}
	}
}
