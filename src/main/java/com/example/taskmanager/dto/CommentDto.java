package com.example.taskmanager.dto;

import com.example.taskmanager.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {

  private Long issueId;
  private Long userId;
  private String commentBody;

  public static CommentDto fromComment(Comment comment){

    return new CommentDtoBuilder().issueId(comment.getIssue().getIssueId())
            .userId(comment.getUser().getUserId())
            .commentBody(comment.getCommentBody()).build();

  }



}
