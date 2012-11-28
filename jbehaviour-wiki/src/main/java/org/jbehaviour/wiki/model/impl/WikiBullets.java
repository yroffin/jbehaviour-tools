package org.jbehaviour.wiki.model.impl;

import org.jbehaviour.wiki.model.IWikiToken;
import org.jbehaviour.wiki.model.WikiToken;

public class WikiBullets extends WikiToken {
	public WikiBullets(IWikiToken owner,String value) {
		super(owner,value);
		type = IWikiToken.types.IWikiTokenBullets;
	}

	@Override
	public void toHtml(StringBuilder sb) {
		sb.append("<ul>");
		for(IWikiToken token : tokens) {
			sb.append("<li>");
			token.toHtml(sb);
			sb.append("</li>");
		}
		sb.append("</ul>");
	}
}
