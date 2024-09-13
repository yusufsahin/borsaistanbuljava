package com.borsaistanbul.zz06_projectmanagement.dao.model;

import com.borsaistanbul.zz06_projectmanagement.dao.model.common.BaseModel;
import com.borsaistanbul.zz06_projectmanagement.enumerate.ProjectStatus;
import com.borsaistanbul.zz06_projectmanagement.enumerate.converter.ProjectStatusConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="Projects")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id",nullable = false)
    private  Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Scope")
    private String scope;

    @Column(name = "ProjectManager")
    private String projectManager;

    @Column(name = "ProjectAssistant")
    private String projectAssistant;

    @Temporal(TemporalType.DATE)
    @Column(name = "StartDate")
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "FinishDate")
    private Date finishDate;

    @Convert(converter = ProjectStatusConverter.class)
    @Column(name = "Status")
    private ProjectStatus status;


}
