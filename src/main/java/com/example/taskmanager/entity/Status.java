package com.example.taskmanager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "status")
@Data
@Builder
@NoArgsConstructor
@ToString
@AllArgsConstructor

public  class Status {
    private Long statusId;
    private String statusName;

}
