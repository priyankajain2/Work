package com.spring.springcore.annotation.component;

import org.springframework.stereotype.Component;

@Component
public class Student {
	private String name;
	private int studentId;
	public Student(String name, int studentId) {
		super();
		this.name = name;
		this.studentId = studentId;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", studentId=" + studentId + "]";
	}
	
	

}
