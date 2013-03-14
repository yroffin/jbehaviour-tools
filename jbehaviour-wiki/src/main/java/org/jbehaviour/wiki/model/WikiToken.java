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

package org.jbehaviour.wiki.model;

import java.util.ArrayList;
import java.util.List;

public abstract class WikiToken implements IWikiToken {
	protected IWikiToken.types type;
	protected String value;
	private IWikiToken owner;
	public WikiToken(IWikiToken owner, String value) {
		this.owner = owner;
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	protected List<IWikiToken> tokens = new ArrayList<IWikiToken>();
	@Override
	public IWikiToken add(IWikiToken token) {
		tokens.add(token);
		return token;
	}
	@Override
	public IWikiToken getRoot() {
		return owner;
	}
	@Override
	public String toString() {
		return "WikiToken [type=" + type + ", value=" + value + ", tokens=" + tokens + "]";
	}
	@Override
	public List<IWikiToken> getTokens() {
		return tokens;
	}
}
