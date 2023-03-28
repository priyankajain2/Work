package com.spring.hibernate;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Many2ManyProj {
	
	@Id
	private int pid;
	private String proj_name;
	@ManyToMany
	private List<Many2ManyEmp> employees;
	
	
	public Many2ManyProj(int pid, String proj_name, List<Many2ManyEmp> employees) {
		super();
		this.pid = pid;
		this.proj_name = proj_name;
		this.employees = employees;
	}
	public Many2ManyProj() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getProj_name() {
		return proj_name;
	}
	public void setProj_name(String proj_name) {
		this.proj_name = proj_name;
	}
	public List<Many2ManyEmp> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Many2ManyEmp> employees) {
		this.employees = employees;
	}
	@Override
	public String toString() {
		return "Many2ManyProj [pid=" + pid + ", proj_name=" + proj_name + ", employees=" + employees + "]";
	}
	
	
}
