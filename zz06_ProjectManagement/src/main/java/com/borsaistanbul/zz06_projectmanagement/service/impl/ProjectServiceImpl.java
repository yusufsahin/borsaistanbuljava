package com.borsaistanbul.zz06_projectmanagement.service.impl;

import com.borsaistanbul.zz06_projectmanagement.dao.ProjectRepository;
import com.borsaistanbul.zz06_projectmanagement.dao.model.Project;
import com.borsaistanbul.zz06_projectmanagement.dto.ProjectDto;
import com.borsaistanbul.zz06_projectmanagement.service.ProjectService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProjectDto crateProject(ProjectDto projectDto) {

        Project project = modelMapper.map(projectDto, Project.class);
        project= projectRepository.save(project);
        return modelMapper.map(project, ProjectDto.class);
    }

    @Override
    public List<ProjectDto> getAllProjects() {
        List<Project> projects = projectRepository.findAll();
        return  projects.stream().map(
                project -> modelMapper.map(project,ProjectDto.class)
        ).collect(Collectors.toList());
    }

    @Override
    public ProjectDto getProjectById(Long id) {
       Project project = projectRepository.findById(id).orElseThrow(
               ()->new EntityNotFoundException("Project with id " + id + " not found"));
    return modelMapper.map(project, ProjectDto.class);
    }

    @Override
    public void deleteProjectById(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public ProjectDto updateProject(ProjectDto projectDto) {
        Project existingProject= projectRepository.findById(projectDto.getId())
                .orElseThrow(()->new EntityNotFoundException("Project with id " + projectDto.getId() + " not found"));
        modelMapper.map(projectDto, existingProject);
        existingProject = projectRepository.save(existingProject);
        return modelMapper.map(existingProject, ProjectDto.class);
    }
}
