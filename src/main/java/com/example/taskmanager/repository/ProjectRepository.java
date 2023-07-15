package com.example.taskmanager.repository;

import com.example.taskmanager.dto.ProjectDto;
import com.example.taskmanager.dto.ProjectItemDto;
import com.example.taskmanager.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {

    List<Project> findAllByUserId(Long id);

}
