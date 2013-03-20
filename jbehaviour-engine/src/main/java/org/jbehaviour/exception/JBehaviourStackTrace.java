package org.jbehaviour.exception;

import org.slf4j.Logger;

public class JBehaviourStackTrace {
	
	static public void printStackTrace(Logger logger, Exception e) {
		if(e == null) {
			logger.warn("Exception is null");
			return;
		}
		logger.warn("[Exception]: " + e);
		for(StackTraceElement element : e.getStackTrace()) {
			logger.warn(element.toString());
		}
	}

	public static void printStackTrace(Logger logger, Throwable e) {
		if(e == null) {
			logger.warn("Throwable is null");
			return;
		}
		logger.warn("[Throwable]: " + e);
		for(StackTraceElement element : e.getStackTrace()) {
			logger.warn(element.toString());
		}
	}

}
