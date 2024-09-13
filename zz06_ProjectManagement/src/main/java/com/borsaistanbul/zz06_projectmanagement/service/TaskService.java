package com.borsaistanbul.zz06_projectmanagement.service;

import com.borsaistanbul.zz06_projectmanagement.dto.TaskDto;

import java.util.List;

public interface TaskService {
    TaskDto create(TaskDto taskDto);

    TaskDto getById(Long workitemId,Long id);
    TaskDto getById(Long id);


    List<TaskDto> getTasks();

    void delete(Long id);

    TaskDto update(Long id, TaskDto taskRequest);

    List<TaskDto> findByWorkitemId(Long workitemId);
}
