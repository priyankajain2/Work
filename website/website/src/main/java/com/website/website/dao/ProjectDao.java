package com.website.website.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.website.website.entities.Projects;

public interface ProjectDao extends JpaRepository<Projects, Integer>{

}
