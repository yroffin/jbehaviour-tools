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
