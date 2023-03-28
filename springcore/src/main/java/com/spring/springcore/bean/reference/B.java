package com.spring.springcore.bean.reference;

public class B {
	private String numberb;

	public B() {
		super();
	}

	public String getNumberb() {
		return numberb;
	}

	public void setNumberb(String numberb) {
		this.numberb = numberb;
	}

	public B(String numberb) {
		super();
		this.numberb = numberb;
	}

	@Override
	public String toString() {
		return "B [numberb=" + numberb + "]";
	}
	
}
