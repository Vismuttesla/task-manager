package com.example.taskmanager.dto;

import com.example.taskmanager.entity.Project;
import com.example.taskmanager.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ProjectDto {


    private String projectName;
    private String description;

    public static ProjectDto fromProject(Project project) {

      return new ProjectDtoBuilder().projectName(project.getProjectName())
              .description(project.getDescription()).build();

    }


}
