package com.spring.springcore.bean.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class UsingInterfaces implements InitializingBean, DisposableBean{

	private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "UsingInterfaces [price=" + price + "]";
	}

	public UsingInterfaces() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void destroy() throws Exception {
		System.out.println("USingInterface bean is destroyed");
		
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("initializatiojn step of USINGinterface bean");
		
	}
	
	
}
