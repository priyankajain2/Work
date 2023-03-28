package com.website.website.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.website.website.entities.Projects;

public interface ProjectService {
	
	public List<Projects> getProjects();

	public Projects getProjectById(int projectId);

	public Projects addProject(Projects project);

	public void deleteProject(int projectId);

	public Projects updateProjects(Projects project);
}
