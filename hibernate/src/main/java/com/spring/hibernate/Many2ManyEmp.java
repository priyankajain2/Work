package com.spring.hibernate;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Many2ManyEmp {
	
	@Id
	private int eid;
	private String emp_name;
	@ManyToMany
	@JoinTable(
			name="emp_proj", 
			joinColumns = {@JoinColumn(name = "emp_id")}, 
			inverseJoinColumns = {@JoinColumn(name = "proj_id")})
	private List<Many2ManyProj> projects;
	
	public Many2ManyEmp(int eid, String emp_name, List<Many2ManyProj> projects) {
		super();
		this.eid = eid;
		this.emp_name = emp_name;
		this.projects = projects;
	}

	public Many2ManyEmp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public List<Many2ManyProj> getProjects() {
		return projects;
	}

	public void setProjects(List<Many2ManyProj> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Many2ManyEmp [eid=" + eid + ", emp_name=" + emp_name + "]";
	}
	
}
