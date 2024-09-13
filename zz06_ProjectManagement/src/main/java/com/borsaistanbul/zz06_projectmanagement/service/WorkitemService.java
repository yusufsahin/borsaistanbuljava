package com.borsaistanbul.zz06_projectmanagement.service;

import com.borsaistanbul.zz06_projectmanagement.dto.WorkitemDto;

import java.util.List;

public interface WorkitemService {
    WorkitemDto create(WorkitemDto workitemDto);

    WorkitemDto getById(Long id);


    List<WorkitemDto> getWorkitems();

    void delete(Long id);

    WorkitemDto update(Long id, WorkitemDto workitemDto);

    List<WorkitemDto> findAllByProjectId(Long id);
}
