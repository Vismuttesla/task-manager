package com.example.taskmanager.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "issues")
@Data
@Builder
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Issue
{

    //issue_id (Primary key)
    //project_id (Foreign key referencing project.project_id)
    //reporter_id (Foreign key referencing user.user_id)
    //assignee_id (Foreign key referencing user.user_id)
    //title
    //description
    //status
    //priority
    //created_at
    //updated_at
    //due_date "

    //issue_type
    //summary
    //description
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "issue_id")
    private Long issueId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="project_id")
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @CreatedBy
    @JoinColumn(name = "reporter_id")
    private User reporter;
// TODO think how to cascade  and add comment if  it needs

    @OneToMany(mappedBy = "issue", cascade = CascadeType.ALL)
    private List<Comment> comments;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignee_id")
    private User assignee;


     private String title;



    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Type issueType;



    @OneToOne
    @Column(nullable = false)
    private Status status;



    @Column(nullable = false)
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private Date updateAt;

    @Column(name = "due_date", nullable = false)
    private Date dueDate;














}
