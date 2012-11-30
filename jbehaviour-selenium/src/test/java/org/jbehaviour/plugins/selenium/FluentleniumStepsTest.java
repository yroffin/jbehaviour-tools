package org.jbehaviour.plugins.selenium;

import static org.junit.Assert.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.jbehaviour.exception.JBehaviourParsingError;
import org.jbehaviour.exception.JBehaviourRuntimeError;
import org.jbehaviour.parser.model.IKeywordStatement;
import org.jbehaviour.reflexion.IBehaviourReflexion;
import org.jbehaviour.reflexion.IBehaviourReflexionContext;
import org.jbehaviour.reflexion.impl.JBehaviourReflexion;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FluentleniumStepsTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, JBehaviourParsingError, JBehaviourRuntimeError {
		IBehaviourReflexion registry = new JBehaviourReflexion();
		registry.register("selenium","org.jbehaviour.plugins.selenium.FluentleniumSteps");
		registry.register("system","org.jbehaviour.plugins.system.SystemSteps");
		
		/**
		 * retrieve and execute on context
		 */
		IBehaviourReflexionContext search = null;
		search = registry.retrieve("noname",IKeywordStatement.statement.Given,"launch the html navigator");
		assertNotNull(search);
		search.execute();
		search = registry.retrieve("noname",IKeywordStatement.statement.When,"i goto to 'http://www.google.com'");
		assertNotNull(search);
		search.execute();
		search = registry.retrieve("noname",IKeywordStatement.statement.Then,"close internet browser");
		assertNotNull(search);
		search.execute();
	}

}
