package com.website.website.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.website.website.entities.Projects;
import com.website.website.service.ProjectService;

@RestController
public class Controller {
	
	@Autowired
	private ProjectService projectService;
	
	@GetMapping("/home")
	public String home() {
		return "I will rock!";
	}
	
	@GetMapping("/projects")
	public List<Projects> getProjects(){
		return this.projectService.getProjects();
	}
	
	@GetMapping("/projects/{projectId}")
	public Projects getProjectById(@PathVariable String projectId) {
		return this.projectService.getProjectById(Integer.parseInt(projectId));
	}
	
	@PostMapping("/projects")
	public Projects addProject(@RequestBody Projects project) {
		return this.projectService.addProject(project);
	}
	
	@DeleteMapping("/projects/{projectId}")
	public ResponseEntity<HttpStatus> deleteProject(@PathVariable String projectId) {
		
		try{
			this.projectService.deleteProject(Integer.parseInt(projectId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/projects")
	public Projects updateProjects(@RequestBody Projects project) {
		return this.projectService.updateProjects(project);
	}
}
