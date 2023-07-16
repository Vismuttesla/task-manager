package com.example.taskmanager.dto;

import com.example.taskmanager.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ProjectItemDto {

    private Long projectId;
    private String projectName;
   // private String description;
   // private String createdBy;
    private Date createdAt;

    public static ProjectItemDto fromProject(Project project) {

        return new ProjectItemDtoBuilder().
                projectId(project.getId()).
                projectName(project.getProjectName()).
     //           description(project.getDescription()).
                createdAt(project.getCreatedAt()).
                build();

    }

}
