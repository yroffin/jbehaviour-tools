package org.jbehaviour.wiki.model.impl;

import org.jbehaviour.wiki.model.IWikiToken;
import org.jbehaviour.wiki.model.WikiToken;

public class WikiItalics extends WikiToken {
	public WikiItalics(IWikiToken owner,String value) {
		super(owner,value);
		type = IWikiToken.types.IWikiTokenItalics;
	}

	@Override
	public void toHtml(StringBuilder sb) {
		sb.append("<em>"+value+"</em>");		
	}
}
