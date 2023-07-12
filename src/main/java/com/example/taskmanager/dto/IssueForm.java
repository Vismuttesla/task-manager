package com.example.taskmanager.dto;

import com.example.taskmanager.entity.Status;
import com.example.taskmanager.entity.Type;
import com.example.taskmanager.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class IssueForm {

    private Long projectId;
    private String assigneeName;
    private String title;
    private String description;

    private Type issueType;
    private String status;


}
