package com.spring.springcore.annotation.value;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("ob")
public class Student {
	@Value("Prianka Jain")
	private String name;
	
	@Value("1")
	private int studentId;
	
	@Value("#{listValueFromXML}")
	private List<String> subjects;
	
	public List<String> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}
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
		return "Student [name=" + name + ", studentId=" + studentId + ", subjects=" + subjects + "]";
	}
	
	

}
