package com.spring.hibernate;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class One2ManyQuestion {
	
	@Id
	private int q_id;
	private String question;
	@OneToMany(mappedBy = "question")
	private List<Many2OneAnswer> answer;
	
	public One2ManyQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public One2ManyQuestion(int q_id, String question, List<Many2OneAnswer> answer) {
		super();
		this.q_id = q_id;
		this.question = question;
		this.answer = answer;
	}
	public int getQ_id() {
		return q_id;
	}
	public void setQ_id(int q_id) {
		this.q_id = q_id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<Many2OneAnswer> getAnswer() {
		return answer;
	}
	public void setAnswer(List<Many2OneAnswer> answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "One2ManyQuestion [q_id=" + q_id + ", question=" + question + "]";
	}
	
}
