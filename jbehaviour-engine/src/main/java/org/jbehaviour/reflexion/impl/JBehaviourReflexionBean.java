package org.jbehaviour.reflexion.impl;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.jbehaviour.annotation.Given;
import org.jbehaviour.annotation.Store;
import org.jbehaviour.annotation.Then;
import org.jbehaviour.annotation.When;
import org.jbehaviour.exception.JBehaviourPasingError;
import org.jbehaviour.parser.model.IKeywordStatement;
import org.jbehaviour.reflexion.IBehaviourEnv;
import org.jbehaviour.reflexion.IBehaviourReflexionBean;
import org.jbehaviour.reflexion.IBehaviourReflexionMethodBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JBehaviourReflexionBean implements IBehaviourReflexionBean {
	Logger logger = LoggerFactory.getLogger(JBehaviourReflexionBean.class);

	List<IBehaviourReflexionMethodBean> anys   = new ArrayList<IBehaviourReflexionMethodBean>();
	List<IBehaviourReflexionMethodBean> givens = new ArrayList<IBehaviourReflexionMethodBean>();
	List<IBehaviourReflexionMethodBean> whens  = new ArrayList<IBehaviourReflexionMethodBean>();
	List<IBehaviourReflexionMethodBean> thens  = new ArrayList<IBehaviourReflexionMethodBean>();
	List<IBehaviourReflexionMethodBean> stores = new ArrayList<IBehaviourReflexionMethodBean>();

	protected String klass;
	protected Class<?> myKlass;
	
	public JBehaviourReflexionBean(String _klass, Class<?> _myKlass) {
		klass = _klass;
		myKlass = _myKlass;
	}
	
	public void addGiven(Given annotation, Method method) throws IOException, JBehaviourPasingError {
		JBehaviourReflexionMethod local = new JBehaviourReflexionMethod(annotation,method);
		givens.add(local);
		anys.add(local);
	}
	
	public void addWhen(When annotation, Method method) throws IOException, JBehaviourPasingError {
		JBehaviourReflexionMethod local = new JBehaviourReflexionMethod(annotation,method);
		whens.add(local);
		anys.add(local);
	}
	
	public void addThen(Then annotation, Method method) throws IOException, JBehaviourPasingError {
		JBehaviourReflexionMethod local = new JBehaviourReflexionMethod(annotation,method);
		thens.add(local);
		anys.add(local);
	}

	@Override
	public void addStore(Store annotation, Method method) throws IOException,
			JBehaviourPasingError {
		JBehaviourReflexionMethod local = new JBehaviourReflexionMethod(annotation,method);
		stores.add(local);
		anys.add(local);
	}

	@Override
	public IBehaviourReflexionMethodBean matchGiven(IKeywordStatement parsedStatement) {
		for(IBehaviourReflexionMethodBean behaviour : givens) {
			if(behaviour.match(parsedStatement)) return behaviour;
		}
		return null;
	}

	@Override
	public IBehaviourReflexionMethodBean matchWhen(IKeywordStatement parsedStatement) {
		for(IBehaviourReflexionMethodBean behaviour : whens) {
			if(behaviour.match(parsedStatement)) return behaviour;
		}
		return null;
	}

	@Override
	public IBehaviourReflexionMethodBean matchThen(IKeywordStatement parsedStatement) {
		for(IBehaviourReflexionMethodBean behaviour : thens) {
			if(behaviour.match(parsedStatement)) return behaviour;
		}
		return null;
	}

	@Override
	public IBehaviourReflexionMethodBean matchStore(
			IKeywordStatement parsedStatement) {
		for(IBehaviourReflexionMethodBean behaviour : stores) {
			if(behaviour.match(parsedStatement)) return behaviour;
		}
		return null;
	}

	public Object getInstance(IBehaviourEnv env) throws InstantiationException, IllegalAccessException, ClassNotFoundException, JBehaviourPasingError {
		return env.getInstance(klass);
	}
}
