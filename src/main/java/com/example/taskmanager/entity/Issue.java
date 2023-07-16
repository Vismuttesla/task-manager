package com.example.taskmanager.entity;

//import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "issues")
@Data
@Builder
@NoArgsConstructor
@ToString
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Issue
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "issue_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="project_id")
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @CreatedBy
    @JoinColumn(name = "reporter_id")
    private User reporter;
// TODO think how to cascade  and add comment if  it needs

    @OneToMany(mappedBy = "issue", cascade = CascadeType.ALL)
     //@JoinColumn
    private List<Comment> comments;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignee_id")
    private User assignee;


     private String title;



    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Type issueType;



    @OneToOne
    @JoinColumn(nullable = false,name = "status_name",referencedColumnName = "name")
    private Status status;



    @Column(nullable = false)
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(name = "updated_at")
    private Date updateAt;

    @Column(name = "due_date")
    private Date dueDate;














}
