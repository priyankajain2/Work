package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.ProjectDao;
import com.spring.jdbc.entities.Project;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My Program Strated....." );
        
        //when using XML 
        	//        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        
        //when using java class
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        
			//basic, without proper structure.
        		//        JdbcTemplate template = context.getBean("jdbcTemplate",JdbcTemplate.class);
				//        
				//        //insert query
				//        String query="insert into project(id,title,description) values(?,?,?)";
				//        
				//        //fire query
				//        int result = template.update(query,3,"Optimized Cameras","a java application");
				//        System.out.println("number of rows inserted " + result);
        
        //with proper structure, since we have called the object of jdbcTemplate in projectDao class,
        //now we have to call the projectDao object directly by passing jdbctemplate into projectDao object
        //this can be done in xml file by creating a bean of projectDao and pass the reference of already created object
        
        ProjectDao projectDao = context.getBean("projectDao",ProjectDao.class);
        
        //sample data
//        Project project = new Project();
//        project.setId(3);
//        project.setTitle("Optimized Security Camera Installation");
//        project.setDescription("A Back-End Program");
        
        //insert
//        int result = projectDao.insert(project);
//        System.out.println("the number of rows effected: " + result);
        
        //update
//        int result = projectDao.updated(project);
//        System.out.println("number of rows effected: " +result);
        
        
        //delete
//        int result = projectDao.delete(2);
//        System.out.println("rows deleted: "+ result);
        
        //selecting one row
        Project project = projectDao.getProject(1);
        System.out.println(project);
        
        //selecting the complete table
        List<Project> projects = projectDao.getAllProjects();
        for(Project p : projects) {
        	System.out.println(p);
        }
    }
}
