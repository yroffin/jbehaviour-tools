/**
 *  Copyright 2012 Yannick Roffin
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *   limitations under the License.
 */

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
