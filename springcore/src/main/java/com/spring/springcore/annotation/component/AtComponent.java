package com.spring.springcore.annotation.component;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AtComponent {
	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/springcore/annotation/component/stereoConfig.xml");
		Student student = context.getBean("student",Student.class);
		System.out.println(student);
	}

}
