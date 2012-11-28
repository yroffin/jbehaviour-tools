package org.jbehaviour.wiki.model.impl;

import org.jbehaviour.wiki.model.IWikiToken;
import org.jbehaviour.wiki.model.WikiToken;

public class WikiNumbered extends WikiToken {
	public WikiNumbered(IWikiToken owner,String value) {
		super(owner,value);
		type = IWikiToken.types.IWikiTokenNumbered;
	}

	@Override
	public void toHtml(StringBuilder sb) {
		sb.append("<ol>");
		for(IWikiToken token : tokens) {
			sb.append("<li>");
			token.toHtml(sb);
			sb.append("</li>");
		}
		sb.append("</ol>");
	}
}
