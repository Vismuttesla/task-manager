package com.example.taskmanager.dto;

import com.example.taskmanager.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.usertype.StaticUserTypeSupport;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class IssueDto {

    private Long projectId;
    private User reporter;
    private User assignee;
    private String title;
    private String description;

    private Type issueType;
    private Status status;


    public static IssueDto fromIssue(Issue issue){
        IssueDto issueDto=new
                IssueDtoBuilder().projectId(issue.getProject().getProjectId())
                .reporter(issue.getReporter())
                .assignee(issue.getAssignee()).title(issue.getTitle()).
        issueType(issue.getIssueType())
                .status(issue.getStatus())
        .description(issue.getDescription()).build();

        return issueDto;
    }


}
