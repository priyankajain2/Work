package com.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Project;

public class RowMapperImpl implements RowMapper<Project> {

	public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
		Project project = new Project();
		project.setId(rs.getInt(1));
		project.setTitle(rs.getString(2));
		project.setDescription(rs.getString(3));
		return project;
	}

}
