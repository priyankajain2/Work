package com.spring.springcore.bean.reference;

public class A {
	private String number;
	private B b;
	
	
	public A() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public B getB() {
		return b;
	}
	public void setB(B b) {
		this.b = b;
	}
	public A(String number, B b) {
		super();
		this.number = number;
		this.b = b;
	}
	@Override
	public String toString() {
		return "A [number=" + number + ", b=" + b + "]";
	}
	
}
