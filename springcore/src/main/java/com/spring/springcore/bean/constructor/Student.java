package com.spring.springcore.bean.constructor;

public class Student {
	private int studentId;
	private String name;
	private Certif certi;
	
	public Student(int studentId, String name, Certif certi) {
		this.studentId = studentId;
		this.name = name;
		this.certi = certi;
	}
	
	@Override
	public String toString() {
		return this.studentId + " " + this.name + " " + this.certi;
	}
	

}
