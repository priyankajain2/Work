package com.spring.springcore.bean.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class UsingAnnotations {
	
	private double price;

	public UsingAnnotations() {
		super();
		// TODO Auto-generated constructor stub
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "UsingAnnotations [price=" + price + "]";
	}
	
	@PostConstruct
	public void start() {
		System.out.println("insid start");
	}
	
	@PreDestroy
	public void end() {
		System.out.println("inside end");
	}
}
