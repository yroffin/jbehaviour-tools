package org.jbehaviour;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.jbehaviour.exception.JBehaviourParsingError;
import org.jbehaviour.exception.JBehaviourRuntimeError;
import org.jbehaviour.impl.JBehaviourLauncher;

public class JBehaviourMain {
	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws JBehaviourParsingError 
	 * @throws IOException 
	 * @throws InstantiationException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws JBehaviourRuntimeError 
	 */
	public static void main(String[] args) throws JBehaviourParsingError, JBehaviourRuntimeError {
		System.out.println("JBehaviourLauncher 1.0\nusage: JBehaviourLauncher --story <story file>\n");
		String story = null;
		/**
		 * command line analysis
		 */
		int index = 0;
		for(String argument : args) {
			if("-s".compareTo(argument)==0 || "--story".compareTo(argument)==0) {
				story = args[index+1];
			}
			index++;
		}

		if(!(new JBehaviourLauncher()).registerAndExecute(new File(story))) {
			System.err.println("Fail to execute this story");
		}
	}
}
