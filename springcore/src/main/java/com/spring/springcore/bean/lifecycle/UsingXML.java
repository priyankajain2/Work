package com.spring.springcore.bean.lifecycle;

public class UsingXML {
	
	private double price;
	
	public UsingXML() {
		super();
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
		System.out.println("inside setter method");
	}

	
	
	@Override
	public String toString() {
		return "UsingXML [price=" + price + "]";
	}

	public void init() {
		System.out.println("inside init method. you can write or perform anything you want before the bean is called");
	}
	
	public void destroy() {
		System.out.println("inside destroy(). you can perform or write anything before object is destroyed.");
	}

}
