package com.example.taskmanager.controller;

import com.example.taskmanager.dto.ProjectForm;
import com.example.taskmanager.entity.Status;
import com.example.taskmanager.service.StatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/task-manager/user/project/issue/status/")

public class StatusController {

    private StatusService service;

    @PostMapping("add")
    public ResponseEntity add(@RequestBody Status status) {
        return ResponseEntity.ok(service.add(status));
    }



}
