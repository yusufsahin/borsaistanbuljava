package com.borsaistanbul.zz06_projectmanagement.dto;

import com.borsaistanbul.zz06_projectmanagement.enumerate.ProjectStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {
    private Long id;
    private String name;
    private String description;
    private String scope;
    private String memo;
    private String projectManager;
    private String projectAssistant;
    private Date startDate;
    private Date finishDate;
    private ProjectStatus status;

}
