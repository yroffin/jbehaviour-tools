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

package org.jbehaviour.plugins;

import java.util.ArrayList;
import java.util.List;

public class ComplexBean {

	public Integer simple = new Integer(1000);
	public Integer getSimple() {
		return simple;
	}

	public int value = 20;
	public String another = "another value";

	List<ComplexBean> subbeans = new ArrayList<ComplexBean>();

	public ComplexBean getSubbean(int i) {
		return subbeans.get(i);
	}

	public ComplexBean() {
		subbeans.add(new ComplexBean(1));
		subbeans.add(new ComplexBean(2));
		subbeans.add(new ComplexBean(3));
		subbeans.add(new ComplexBean(4));
	}

	public ComplexBean(int _simple) {
		simple = new Integer(_simple);
	}

	@Override
	public String toString() {
		return "ComplexBean [simple=" + simple + ", value=" + value
				+ ", another=" + another + ", subbeans=" + subbeans + "]";
	}	
}
