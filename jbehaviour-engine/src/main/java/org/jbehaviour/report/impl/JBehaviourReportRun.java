package org.jbehaviour.report.impl;

import java.util.Arrays;

import org.jbehaviour.report.IBehaviourReportRun;

public class JBehaviourReportRun implements IBehaviourReportRun {

	private Long duration;
	private String klass;
	private String name;
	private String text;
	private String textLikeMethod;
	private Object object;
	private Object[] args;

	public JBehaviourReportRun(String _klass, Long _duration, String _name, Object _object, Object[] _args, String _text) {
		klass = _klass;
		duration = _duration;
		name = _name;
		object = _object;
		args = _args;
		text = _text;
		StringBuilder sb = new StringBuilder();
		for(String item : _text.split(" ")) {
			String value = item.replace("$", "").toLowerCase();
			if(sb.length() > 0) {
				sb.append(value.substring(0, 1).toUpperCase());
			} else {
				sb.append(value.substring(0, 1).toLowerCase());
			}
			sb.append(value.substring(1));
		}
		textLikeMethod = sb.toString();
	}

	@Override
	public String getKlass() {
		return klass;
	}

	@Override
	public String getText() {
		return text;
	}

	@Override
	public String getTextLikeMethod() {
		return textLikeMethod;
	}

	@Override
	public Long getDuration() {
		return duration;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Object getObject() {
		return object;
	}

	@Override
	public Object[] getArgs() {
		return args;
	}

	@Override
	public String toString() {
		return "JBehaviourReportRun [duration=" + duration + ", name=" + name
				+ ", object=" + object + ", args=" + Arrays.toString(args)
				+ "]";
	}

}
