package com.example.taskmanager.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IssueItemDto {

    private Long IssueId;
    private String reporter;
    private String assignee;
    private String  title;


}
