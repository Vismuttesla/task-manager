package com.example.taskmanager.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "status")
@Data
@Builder
@NoArgsConstructor
@ToString
@AllArgsConstructor

public  class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private Long statusId;

    private String statusName;

}
