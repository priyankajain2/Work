package com.spring.springcore.bean.constructor;

public class Certif {
	
	private String name;
	
	public Certif(String name) {
		this.name=name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
