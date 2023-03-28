package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Project;

public class ProjectDaoImpl implements ProjectDao{
	
	private JdbcTemplate jdbcTemplate;

	public int insert(Project project) {
		String query = "insert into project(id,title,description) values(?,?,?)";
		int result = this.jdbcTemplate.update(query,project.getId(),project.getTitle(),project.getDescription());
		return result;
	}
	
	public int updated(Project project) {
		String query = "update project set title=?,description=? where id=?";
		int result = this.jdbcTemplate.update(query,project.getTitle(),project.getDescription(),project.getId());
		return result;
	}
	
	public int delete(int id) {
		String query = "delete from project where id=?";
		int result = this.jdbcTemplate.update(query,id);
		return result;
	}

	public Project getProject(int id) {
		String query = "select * from project where id=?";
		RowMapper<Project> rowMapper = new RowMapperImpl();
		Project project = this.jdbcTemplate.queryForObject(query, rowMapper,id);
		return project;
	}

	public List<Project> getAllProjects() {
		String query = "select * from project";
		List<Project> projects = this.jdbcTemplate.query(query, new RowMapperImpl());
		return projects;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
