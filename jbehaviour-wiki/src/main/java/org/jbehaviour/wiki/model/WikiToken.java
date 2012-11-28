package org.jbehaviour.wiki.model;

import java.util.ArrayList;
import java.util.List;

public abstract class WikiToken implements IWikiToken {
	protected IWikiToken.types type;
	protected String value;
	private IWikiToken owner;
	public WikiToken(IWikiToken _owner, String _value) {
		owner = _owner;
		value = _value;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	protected List<IWikiToken> tokens = new ArrayList<IWikiToken>();
	@Override
	public IWikiToken add(IWikiToken token) {
		tokens.add(token);
		return token;
	}
	@Override
	public IWikiToken getRoot() {
		return owner;
	}
	@Override
	public String toString() {
		return "WikiToken [type=" + type + ", value=" + value + ", tokens=" + tokens + "]";
	}
	@Override
	public List<IWikiToken> getTokens() {
		return tokens;
	}
}
