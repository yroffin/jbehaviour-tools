package org.jbehaviour.wiki.model.impl;

import org.jbehaviour.wiki.model.IWikiToken;
import org.jbehaviour.wiki.model.WikiToken;

public class WikiContent extends WikiToken {
	public WikiContent(IWikiToken owner,String value) {
		super(owner,value);
		type = IWikiToken.types.IWikiTokenContent;
	}

	@Override
	public void toHtml(StringBuilder sb) {
		sb.append(value);		
	}
}
