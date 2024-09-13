package com.borsaistanbul.zz06_projectmanagement.controller;

import com.borsaistanbul.zz06_projectmanagement.dto.WorkitemDto;
import com.borsaistanbul.zz06_projectmanagement.service.WorkitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workitems")
public class WorkitemController {
    private final WorkitemService workitemService;

    @Autowired
    public WorkitemController(WorkitemService workitemService) {
        this.workitemService = workitemService;
    }
    // Create a new Workitem
    @PostMapping
    public ResponseEntity<WorkitemDto> createWorkitem(@RequestBody WorkitemDto workitemDto) {
        WorkitemDto createdWorkitem = workitemService.create(workitemDto);
        return new ResponseEntity<>(createdWorkitem, HttpStatus.CREATED);
    }

    // Get a Workitem by ID
    @GetMapping("/{id}")
    public ResponseEntity<WorkitemDto> getWorkitemById(@PathVariable Long id) {
        WorkitemDto workitemDto = workitemService.getById(id);
        return new ResponseEntity<>(workitemDto, HttpStatus.OK);
    }

    // Get all Workitems or filter by Project ID using Request Param
    @GetMapping
    public ResponseEntity<List<WorkitemDto>> getAllWorkitems(@RequestParam(value = "projectId", required = false) Long projectId) {
        List<WorkitemDto> workitems;
        if (projectId != null) {
            workitems = workitemService.findAllByProjectId(projectId);
        } else {
            workitems = workitemService.getWorkitems();
        }
        return new ResponseEntity<>(workitems, HttpStatus.OK);
    }

    // Update a Workitem
    @PutMapping("/{id}")
    public ResponseEntity<WorkitemDto> updateWorkitem(@PathVariable Long id, @RequestBody WorkitemDto workitemDto) {
        WorkitemDto updatedWorkitem = workitemService.update(id, workitemDto);
        return new ResponseEntity<>(updatedWorkitem, HttpStatus.OK);
    }

    // Delete a Workitem
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkitem(@PathVariable Long id) {
        workitemService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
