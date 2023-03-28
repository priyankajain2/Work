package com.spring.springcore.bean.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycleMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/springcore/lifecycle/configCycle.xml");
		
		//Using XML
			UsingXML xml1 = (UsingXML)context.getBean("xml1");
			System.out.println(xml1);
			//to runt he destro method you have to call the registershutdownhook, which is inside
			//abstractapplicationcontext istead of applicationcontext
			AbstractApplicationContext context2 = new ClassPathXmlApplicationContext("com/spring/springcore/lifecycle/configCycle.xml");
			UsingXML xml2 = (UsingXML)context2.getBean("xml1");
			context2.registerShutdownHook();
			System.out.println(xml2);
			
			UsingInterfaces interface1 = (UsingInterfaces)context.getBean("interface1");
			System.out.println(interface1);
			
			UsingAnnotations annot1 = (UsingAnnotations)context.getBean("annot1");
			System.out.println(annot1);
	}

}
