package com.borsaistanbul.zz06_projectmanagement.service.impl;

import com.borsaistanbul.zz06_projectmanagement.dao.TaskRepository;
import com.borsaistanbul.zz06_projectmanagement.dao.WorkitemRepository;
import com.borsaistanbul.zz06_projectmanagement.dao.model.Task;
import com.borsaistanbul.zz06_projectmanagement.dao.model.Workitem;
import com.borsaistanbul.zz06_projectmanagement.dto.TaskDto;
import com.borsaistanbul.zz06_projectmanagement.service.TaskService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private ModelMapper modelMapper;  // Inject ModelMapper

    @Autowired
    private WorkitemRepository workitemRepository;


    @Override
    public TaskDto create(TaskDto taskDto) {
        Task task = mapToEntity(taskDto);
        task.setId(0L);

        Workitem workitem = workitemRepository.findById(taskDto.getWorkitemId()).orElseThrow(
                () -> new EntityNotFoundException("Workitem not found" + taskDto.getWorkitemId()));

        task.setWorkitem(workitem);
        Task newTask = taskRepository.save(task);

        return mapToDTO(newTask);
    }

    @Override
    public TaskDto getById(Long workitemId, Long id) {
        Workitem post = workitemRepository.findById(workitemId).orElseThrow(
                () -> new EntityNotFoundException("Workitem not found" + workitemId));

        Task task = taskRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Task not found" + id));

        if (!task.getWorkitem().getId().equals(post.getId())) {
            throw new IllegalArgumentException("Task does not belong to workitem id" + workitemId);
        }

        return mapToDTO(task);
    }

    @Override
    public TaskDto getById(Long id) {
        return null;
    }

    @Override
    public List<TaskDto> getTasks() {
        List<Task> data = taskRepository.findAll();
        return Arrays.asList(modelMapper.map(data, TaskDto[].class));
    }

    @Override
    public void delete(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Task not found" + id));
        taskRepository.delete(task);
    }

    @Override
    public TaskDto update(Long id, TaskDto taskRequest) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task not found" + id));

        // Map fields using ModelMapper
        modelMapper.map(taskRequest, task);

        Task updatedTask = taskRepository.save(task);
        return mapToDTO(updatedTask);
    }

    @Override
    public List<TaskDto> findByWorkitemId(Long workitemId) {
        List<Task> tasks = taskRepository.findByWorkitemId(workitemId);
        return tasks.stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    private TaskDto mapToDTO(Task task) {
        return modelMapper.map(task, TaskDto.class);
    }

    private Task mapToEntity(TaskDto taskDto) {
        return modelMapper.map(taskDto, Task.class);
    }
}
