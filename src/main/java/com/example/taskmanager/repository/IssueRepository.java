package com.example.taskmanager.repository;

import com.example.taskmanager.entity.Issue;
import com.example.taskmanager.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {

    List<Issue> findAllByProjectId(Long id);


}
