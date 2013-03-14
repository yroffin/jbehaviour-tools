package org.jbehaviour.exception;

import org.slf4j.Logger;

public class JBehaviourStackTrace {
	
	static public void printStackTrace(Logger logger, Exception e) {
		for(StackTraceElement element : e.getStackTrace()) {
			logger.warn(element.toString());
		}
	}

	public static void printStackTrace(Logger logger, Throwable e) {
		for(StackTraceElement element : e.getStackTrace()) {
			logger.warn(element.toString());
		}
	}

}
