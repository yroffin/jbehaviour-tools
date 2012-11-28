package org.jbehaviour.wiki.model.impl;

import org.jbehaviour.wiki.model.IWikiToken;
import org.jbehaviour.wiki.model.WikiToken;

public class WikiHeadings extends WikiToken {
	public WikiHeadings(IWikiToken owner,String value) {
		super(owner,value);
		type = IWikiToken.types.IWikiTokenHeadings;
	}

	@Override
	public void toHtml(StringBuilder sb) {
		sb.append("<h"+value.length()+">");
		for(IWikiToken token : tokens) {
			token.toHtml(sb);
		}
		sb.append("</h"+value.length()+">");
	}
}
