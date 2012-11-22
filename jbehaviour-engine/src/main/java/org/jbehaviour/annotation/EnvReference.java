package org.jbehaviour.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface EnvReference {
	/**
	 * this annotation permit to inject
	 * environnement reference at runtime
	 */
}
