package com.spring.hibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Questions {
	
	@Id
	private int q_id;
	private String que;
	
	@OneToOne 	//same as mentioning the foriegn key
	@JoinColumn(name = "a_id")
	private Answers answer;
	
	public Questions(int q_id, String que, Answers ans) {
		super();
		this.q_id = q_id;
		this.que = que;
		this.answer = ans;
	}
	public Questions() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getQ_id() {
		return q_id;
	}
	public void setQ_id(int q_id) {
		this.q_id = q_id;
	}
	public String getQue() {
		return que;
	}
	public void setQue(String que) {
		this.que = que;
	}
	public Answers getAns() {
		return answer;
	}
	public void setAns(Answers ans) {
		this.answer = ans;
	}
	@Override
	public String toString() {
		return "Questions [q_id=" + q_id + ", que=" + que + "]";
	}
	
	
	

}
