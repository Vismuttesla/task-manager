package com.example.taskmanager.service;


import com.example.taskmanager.dto.*;

import java.util.List;

public interface CommentService {

    CommentDto add(CommentForm form);

    CommentDto update(Long id,CommentForm form);
    List<CommentDto> comments(Long IssueId);

    Boolean delete(Long id);



}
