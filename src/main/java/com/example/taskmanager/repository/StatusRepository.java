package com.example.taskmanager.repository;

import ch.qos.logback.core.status.StatusUtil;
import com.example.taskmanager.entity.Project;
import com.example.taskmanager.entity.Status;
import com.example.taskmanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status,Long>
{
    Status findStatusByName(String name);



}
