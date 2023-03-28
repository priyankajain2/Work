package com.spring.springcore.bean.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TryMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/springcore/constructor/configConst.xml");
		
		Student student1 = (Student)context.getBean("student1");
		System.out.println(student1);

		Ambiguity ambiguity1 = (Ambiguity)context.getBean("ambiguity1");
		System.out.println(ambiguity1);
	}

}
