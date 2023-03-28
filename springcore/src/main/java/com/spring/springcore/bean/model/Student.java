package com.spring.springcore.bean.model;

import java.util.List;
import java.util.Map;

public class Student {

	private String name;
	private long studentId;
	private String address;
	private List<Integer> marks;
	private Map<Integer,String> subjects;
	
	public List<Integer> getMarks() {
		return marks;
	}

	public void setMarks(List<Integer> marks) {
		this.marks = marks;
	}

	public Student(String name, long studentId, String address, List<Integer> marks, Map<Integer,String> subjects) {
		super();
		this.name = name;
		this.studentId = studentId;
		this.address = address;
		this.marks = marks;
		this.subjects = subjects;
	}

	
	public Map<Integer, String> getSubjects() {
		return subjects;
	}

	public void setSubjects(Map<Integer, String> subjects) {
		this.subjects = subjects;
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
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", studentId=" + studentId + ", address=" + address + ", marks=" + marks
				+ ", subjects=" + subjects + "]";
	}
	
}
