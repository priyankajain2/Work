package com.spring.hibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Many2OneAnswer {
	
	@Id
	private int a_id;
	private String answer;
	@ManyToOne
	private One2ManyQuestion question;
	
	public Many2OneAnswer(int a_id, String answer) {
		super();
		this.a_id = a_id;
		this.answer = answer;
	}
	
	public One2ManyQuestion getQuestion() {
		return question;
	}
	public void setQuestion(One2ManyQuestion question) {
		this.question = question;
	}
	public Many2OneAnswer() {
		super();
	}
	public int getA_id() {
		return a_id;
	}
	public void setA_id(int a_id) {
		this.a_id = a_id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "Many2OneAnswer [a_id=" + a_id + ", answer=" + answer + "]";
	}
	
}
