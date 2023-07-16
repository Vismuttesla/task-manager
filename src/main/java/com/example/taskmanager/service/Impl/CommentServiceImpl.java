package com.example.taskmanager.service.Impl;

import com.example.taskmanager.dto.CommentDto;
import com.example.taskmanager.dto.CommentForm;
import com.example.taskmanager.dto.IssueForm;
import com.example.taskmanager.entity.Comment;
import com.example.taskmanager.entity.Issue;
import com.example.taskmanager.repository.CommentRepository;
import com.example.taskmanager.repository.IssueRepository;
import com.example.taskmanager.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
 private final CommentRepository commentRepository;
private final IssueRepository issueRepository;
    @Override
    public CommentDto add(CommentForm form) {

        return CommentDto.fromComment(commentRepository.save(fillComment(new Comment(),form)));

    }

    @Override
    public CommentDto update(Long id, CommentForm form) {

        return CommentDto.fromComment(commentRepository.save(fillComment(commentRepository.getReferenceById(id),form)));

    }

    @Override
    public List<CommentDto> comments(Long issueId) {


        return commentRepository.findAllByIssueId(issueId).
                stream().map(CommentDto::fromComment).collect(Collectors.toList());
    }

    @Override
    public Boolean delete(Long id) {
        commentRepository.deleteById(id);
        Comment comment=commentRepository.getReferenceById(id);
        if (comment!=null) {
            return true;
        }

        return false;
    }

    private Comment fillComment(Comment comment,CommentForm form){
      return comment.builder().issue(issueRepository.getReferenceById(form.getIssueId())).
             commentBody(form.getCommentBody()).
             build();
           }


}
