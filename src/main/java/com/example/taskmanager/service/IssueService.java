package com.example.taskmanager.service;

import com.example.taskmanager.dto.*;
import com.example.taskmanager.entity.Comment;
import com.example.taskmanager.entity.Issue;

import java.util.List;

public interface IssueService {


    IssueDto add(IssueForm form);
    IssueDto findOne(Long id);

    IssueDto update(Long id,IssueForm issueForm);
    List<IssueItemDto> issues(Long projectId);
    //List<CommentDto> comments(Long id);

    Boolean delete(Long id);



}
