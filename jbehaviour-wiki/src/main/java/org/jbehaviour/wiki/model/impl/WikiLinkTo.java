package org.jbehaviour.wiki.model.impl;

import org.jbehaviour.wiki.model.IWikiToken;
import org.jbehaviour.wiki.model.WikiToken;

public class WikiLinkTo extends WikiToken {
	public WikiLinkTo(IWikiToken owner,String value) {
		super(owner,value);
		type = IWikiToken.types.IWikiTokenLinkTo;
	}

	@Override
	public void toHtml(StringBuilder sb) {
		sb.append("<a href=\");");
		sb.append(value);
		sb.append("\">link</a>");		
	}
}
