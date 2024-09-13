package com.borsaistanbul.zz06_projectmanagement.dao;

import com.borsaistanbul.zz06_projectmanagement.dao.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
