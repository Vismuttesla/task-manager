package com.example.taskmanager.dto;


import com.example.taskmanager.entity.Issue;
import com.example.taskmanager.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IssueItemDto {

    private Long issueId;
    private String reporter;
    private String assignee;
    private String  title;
    private String  issueTypeName;
    private String  statusName;

    public static IssueItemDto fromIssue(Issue issue)
    {
        return new
                IssueItemDtoBuilder().issueId(issue.getIssueId()).
                reporter(issue.getReporter().getUsername()).
                assignee(issue.getAssignee().getUsername()).
                title(issue.getTitle()).
                issueTypeName(issue.getIssueType().toString())
                .statusName(issue.getStatus().toString()).
                build();

    }

}
