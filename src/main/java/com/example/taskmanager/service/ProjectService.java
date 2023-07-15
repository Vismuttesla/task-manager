package com.example.taskmanager.service;

import com.example.taskmanager.dto.IssueItemDto;
import com.example.taskmanager.dto.ProjectDto;
import com.example.taskmanager.dto.ProjectForm;
import com.example.taskmanager.dto.ProjectItemDto;
import com.example.taskmanager.entity.Project;

import java.util.List;

public interface ProjectService {

    ProjectDto findOne(Long id);
    ProjectDto add(ProjectForm projectForm);

    ProjectDto update(Long id,ProjectForm projectform);
    List<ProjectItemDto> projects();

    Boolean delete(Long id);


}
