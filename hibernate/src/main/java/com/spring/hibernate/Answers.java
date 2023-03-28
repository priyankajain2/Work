package com.spring.hibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Answers {
	
	@Id
	private int a_id;
	private String answers;
	
	@OneToOne(mappedBy = "answer")
	private Questions que;
	
	
	public Questions getQue() {
		return que;
	}
	public void setQue(Questions que) {
		this.que = que;
	}
	public Answers(int a_id, String answers) {
		super();
		this.a_id = a_id;
		this.answers = answers;
	}
	public Answers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getA_id() {
		return a_id;
	}
	public void setA_id(int a_id) {
		this.a_id = a_id;
	}
	public String getAnswers() {
		return answers;
	}
	public void setAnswers(String answers) {
		this.answers = answers;
	}
	@Override
	public String toString() {
		return "Answers [a_id=" + a_id + ", answers=" + answers + "]";
	}
	
	
}
