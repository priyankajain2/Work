package com.spring.jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.dao.ProjectDao;
import com.spring.jdbc.dao.ProjectDaoImpl;

@Configuration
public class JdbcConfig {
	
	@Bean(name= {"ds"})
	public DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/website");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}
	
	@Bean(name= {"jdbcTemplate"})
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
	
	@Bean(name= {"projectDao"})
	public ProjectDao getProjectDao() {
		ProjectDaoImpl projectDao = new ProjectDaoImpl();
		projectDao.setJdbcTemplate(getJdbcTemplate());
		return projectDao;
	}

}
