package com.website.website.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.website.website.dao.ProjectDao;
import com.website.website.entities.Projects;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectDao proDao;
	//List<Projects> project;
	
	public ProjectServiceImpl() {
//		project = new ArrayList<Projects>();
//		project.add(new Projects(1, "Catch-up", "a java based application"));
//		project.add(new Projects(2, "optimization of security cameras", "Beck-end code developement"));
	}
	

	@Override
	public List<Projects> getProjects() {
		return proDao.findAll();
		//return project;
	}


	@Override
	public Projects getProjectById(int projectId) {
//		Projects pro = null;
//		for(Projects pojo: project) {
//			if(pojo.getId() == projectId) {
//				pro = pojo;
//			}
//		}
//		return pro;
		return proDao.getOne(projectId);
	}


	@Override
	public Projects addProject(Projects pro) {
//		project.add(pro);
//		return pro;
		proDao.save(pro);
		return pro;
	}


	@Override
	public void deleteProject(int projectId) {
		//project = this.project.stream().filter(pro -> pro.getId() != projectId).collect(Collectors.toList());
		Projects pro = proDao.getOne(projectId);
		proDao.delete(pro);
	}


	@Override
	public Projects updateProjects(Projects pro) {
//		for(Projects p : project){
//			if(p.getId() == pro.getId()) {
//				p.setTitle(pro.getTitle());
//				p.setDescription(pro.getDescription());
//			}
//		}
//		return pro;
		proDao.save(pro);
		return pro;
	}

}
