package com.example.taskmanager.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Table(name = "comments")
@Data
@Builder
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Comment {

//comment_id (Primary Key)
//issue_id (Foreign Key referencing Issues.issue_id)
//user_id (Foreign Key referencing Users.user_id)
//comment_body
//created_at
//

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;

    @ManyToOne
    @JoinColumn(name="issue_id")
    private Issue issue;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(name="comment_body")
    private String commentBody;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;



}
