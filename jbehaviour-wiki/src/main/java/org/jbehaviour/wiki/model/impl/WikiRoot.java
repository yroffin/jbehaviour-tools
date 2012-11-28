package org.jbehaviour.wiki.model.impl;

import org.jbehaviour.wiki.model.IWikiToken;
import org.jbehaviour.wiki.model.WikiToken;

public class WikiRoot extends WikiToken {
	public WikiRoot() {
		super(null,"");
		type = IWikiToken.types.IWikiRoot;
	}

	@Override
	public void toHtml(StringBuilder sb) {
		sb.append("<bold>"+value+"</bold>");		
	}
}
