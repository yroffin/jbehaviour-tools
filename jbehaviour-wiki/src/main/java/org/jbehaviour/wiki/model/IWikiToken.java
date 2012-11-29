package org.jbehaviour.wiki.model;

import java.util.List;

public interface IWikiToken {
	public enum types {
		IWikiRoot,
		IWikiTokenContent,
		IWikiTokenItalics,
		IWikiTokenBold,
		IWikiTokenBullets,
		IWikiTokenNumbered,
		IWikiTokenHeadings, 
		IWikiTokenLinkTo,
		IWikiTokenLinkToUrl
	}

	IWikiToken add(IWikiToken token);
	IWikiToken getRoot();
	List<IWikiToken> getTokens();
	void toHtml(StringBuilder sb);
}
