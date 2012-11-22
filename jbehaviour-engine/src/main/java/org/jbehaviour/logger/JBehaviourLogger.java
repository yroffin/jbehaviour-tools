package org.jbehaviour.logger;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;

/**
 * this class initialize the logback system
 */
public class JBehaviourLogger {
	private static boolean initialized = false;
	public static void initialize(String config) {
		if(initialized) return;
	    LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();

	    try {
	      JoranConfigurator configurator = new JoranConfigurator();
	      lc.reset();
	      configurator.setContext(lc);
	      configurator.doConfigure(config);
	    } catch (JoranException je) {
	      StatusPrinter.print(lc.getStatusManager());
	    }
	    initialized = true;
	  }
}
