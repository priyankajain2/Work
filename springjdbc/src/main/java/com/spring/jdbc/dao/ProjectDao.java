package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.entities.Project;

public interface ProjectDao {
	public int insert(Project project);

	public int updated(Project project);

	public int delete(int i);

	public Project getProject(int i);

	public List<Project> getAllProjects();
}
