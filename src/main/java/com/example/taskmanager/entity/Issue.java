package com.example.taskmanager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "tasks")
@Data
@Builder
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Issue
{
   //task_id (Primary Key)
    //task_name
    //description
    //status
    //priority
    //assignee_id (Foreign Key referencing Users.user_id)
    //project_id (Foreign Key referencing Projects.project_id)
    //created_by (Foreign Key referencing Users.user_id)
    //created_at










}
