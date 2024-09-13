package com.borsaistanbul.zz06_projectmanagement.service;

import com.borsaistanbul.zz06_projectmanagement.dto.ProjectDto;

import java.util.List;

public interface ProjectService {
    ProjectDto crateProject(ProjectDto projectDto);
    List<ProjectDto> getAllProjects();
    ProjectDto getProjectById(Long id);
    void deleteProjectById(Long id);
    ProjectDto updateProject(ProjectDto projectDto);
}
