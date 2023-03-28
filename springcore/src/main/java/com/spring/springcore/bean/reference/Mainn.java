package com.spring.springcore.bean.reference;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mainn {

	public static void main(String[] args) {
	ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/springcore/reference/configRef.xml");
	A objectA = (A)context.getBean("refA");
	System.out.println(objectA);
	}

}
