package com.website.website.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Projects {
	
	@Id
	private int id;
	private String title;
	private String description;
	
	public Projects(int id, String title, String description) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
	}
	
	public Projects() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Projects [id=" + id + ", title=" + title + ", description=" + description + "]";
	}
	
	

}
