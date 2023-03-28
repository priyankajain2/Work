package com.spring.springcore.annotation.value;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AtValue {
	
	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/springcore/annotation/value/stereoConfig.xml");
		Student student = context.getBean("ob",Student.class);
		System.out.println(student);
	}

}
