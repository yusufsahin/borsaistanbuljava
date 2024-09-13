package com.borsaistanbul.zz06_projectmanagement.enumerate.converter;

import com.borsaistanbul.zz06_projectmanagement.enumerate.ProjectStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ProjectStatusConverter implements AttributeConverter<ProjectStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(ProjectStatus projectStatus) {

        if (projectStatus == null) return null;
        return projectStatus.getId();
    }

    @Override
    public ProjectStatus convertToEntityAttribute(Integer databaseValue) {
        if (databaseValue == null) return null;

        return ProjectStatus.valueOf(databaseValue);
    }
}
