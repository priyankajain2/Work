package com.spring.springcore.bean.constructor;

public class Ambiguity {
	
	//when there is a ambiguity, always the constructor with parameters as String will execute as we pass our variable
	// in String format. but if there is no constructor whose parameters are in String then the sequence will be followed
	//as in this case we are passing the parameters as "12" and "23" but since double constructor is coming before the 
	//int parameterized constructor, therefore the double constructor will be called. 
	
	private int a;
	private int b;
	
	public Ambiguity(double a, double b) {
		this.a = (int)a;
		this.b = (int)b;
		System.out.println("inside double");
	}
	
	public Ambiguity(int a,int b) {
		this.a = a;
		this.b = b;
		System.out.println("inside integer");
	}
	
//	public Ambiguity(String a, String b) {
//		this.a = Integer.parseInt(a);
//		this.b = Integer.parseInt(b);
//		System.out.println("inside String");
//	}
	
	@Override
	public String toString() {
		return this.a + " " + this.b;
	}

}
