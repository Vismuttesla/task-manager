package com.example.taskmanager.entity;

//import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

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
    private Long id;

    private String name;

}
