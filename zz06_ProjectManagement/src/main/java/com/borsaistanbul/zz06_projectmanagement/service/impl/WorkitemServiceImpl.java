package com.borsaistanbul.zz06_projectmanagement.service.impl;

import com.borsaistanbul.zz06_projectmanagement.dao.ProjectRepository;
import com.borsaistanbul.zz06_projectmanagement.dao.WorkitemRepository;
import com.borsaistanbul.zz06_projectmanagement.dao.model.Project;
import com.borsaistanbul.zz06_projectmanagement.dao.model.Workitem;
import com.borsaistanbul.zz06_projectmanagement.dto.WorkitemDto;
import com.borsaistanbul.zz06_projectmanagement.service.WorkitemService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkitemServiceImpl implements WorkitemService {

    private final WorkitemRepository workitemRepository;
    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public WorkitemServiceImpl(WorkitemRepository workitemRepository, ProjectRepository projectRepository, ModelMapper modelMapper) {
        this.workitemRepository = workitemRepository;
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    // Create Workitem with associated project
    @Override
    public WorkitemDto create(WorkitemDto workitemDto) {
        Project project = findProjectById(workitemDto.getProjectId());

        Workitem workitem = mapToEntity(workitemDto);
        workitem.setProject(project);
        Workitem newWorkitem = workitemRepository.save(workitem);

        return mapToDTO(newWorkitem);
    }

    // Get Workitem by ID, including its associated tasks
    @Override
    public WorkitemDto getById(Long id) {
        Workitem workitem = workitemRepository.findByIdWithTasks(id)
                .orElseThrow(() -> new EntityNotFoundException("Workitem not found with ID " + id));
        return mapToDTO(workitem);
    }

    // Get all Workitems with their tasks
    public List<WorkitemDto> getWorkitems() {
        return workitemRepository.findAllWithTasks().stream()
                .map(workitem -> modelMapper.map(workitem, WorkitemDto.class))
                .collect(Collectors.toList());
    }

    // Delete Workitem by ID
    @Override
    public void delete(Long id) {
        Workitem workitem = workitemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Workitem not found with ID " + id));
        workitemRepository.delete(workitem);
    }

    // Update Workitem
    @Override
    public WorkitemDto update(Long id, WorkitemDto workitemDto) {
        Workitem workitem = workitemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Workitem not found with ID " + id));

        modelMapper.map(workitemDto, workitem);
        workitemRepository.save(workitem);

        return mapToDTO(workitem);
    }

    // Find all Workitems by Project ID, including associated tasks
    @Override
    public List<WorkitemDto> findAllByProjectId(Long id) {
        Project project = findProjectById(id);

        return workitemRepository.findByProjectId(id).stream()
                .map(workitem -> modelMapper.map(workitem, WorkitemDto.class))
                .collect(Collectors.toList());
    }

    // Helper method to find Project by ID and throw EntityNotFoundException if not found
    private Project findProjectById(Long projectId) {
        return projectRepository.findById(projectId)
                .orElseThrow(() -> new EntityNotFoundException("Project not found with ID " + projectId));
    }

    // Convert WorkitemDto to Workitem entity
    private Workitem mapToEntity(WorkitemDto workitemDto) {
        return modelMapper.map(workitemDto, Workitem.class);
    }

    // Convert Workitem entity to WorkitemDto
    private WorkitemDto mapToDTO(Workitem workitem) {
        return modelMapper.map(workitem, WorkitemDto.class);
    }
}
