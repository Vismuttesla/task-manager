package com.example.taskmanager.dto;

import com.example.taskmanager.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class IssueDto {

    private String  projectName;
    private String assignee;
    private String repoter;

    private String title;
    private String description;

    private String issueTypeName;
    private String statusName;
   private Date createdAt;
   private Date updatedAt;

    public static IssueDto fromIssue(Issue issue){
        return new
                IssueDtoBuilder().projectName(issue.getProject().getProjectName()).
                assignee(issue.getAssignee().getUsername()).
                title(issue.getTitle()).
                repoter(issue.getReporter().getUser().getUsername()).
        issueTypeName(issue.getIssueType().toString())
                .statusName(issue.getStatus().toString())
        .description(issue.getDescription()).
                createdAt(issue.getCreatedAt()).
                updatedAt(issue.getUpdateAt()).
                build();


    }


}
