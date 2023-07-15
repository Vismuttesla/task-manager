package com.example.taskmanager.dto;

import com.example.taskmanager.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {



  private String commentBody;
  private String username;
  private Date  createdAt;
  private Date  updatedAt;


  public static CommentDto fromComment(Comment comment)
  {
             return new CommentDtoBuilder()
            .username(comment.getUser().getUsername()).
            createdAt(comment.getCreatedAt()).
            createdAt(comment.getUpdatedAt()).
            commentBody(comment.getCommentBody()).build();
  }



}
