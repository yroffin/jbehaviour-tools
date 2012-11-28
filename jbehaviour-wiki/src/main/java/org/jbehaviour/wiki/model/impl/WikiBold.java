package org.jbehaviour.wiki.model.impl;

import org.jbehaviour.wiki.model.IWikiToken;
import org.jbehaviour.wiki.model.WikiToken;

public class WikiBold extends WikiToken {
	public WikiBold(IWikiToken owner,String value) {
		super(owner,value);
		type = IWikiToken.types.IWikiTokenBold;
	}

	@Override
	public void toHtml(StringBuilder sb) {
		sb.append("<strong>"+value+"</strong>");		
	}
}
