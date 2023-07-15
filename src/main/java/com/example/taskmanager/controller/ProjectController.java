package com.example.taskmanager.controller;

import com.example.taskmanager.dto.IssueItemDto;
import com.example.taskmanager.dto.ProjectDto;
import com.example.taskmanager.dto.ProjectForm;
import com.example.taskmanager.dto.ProjectItemDto;
import com.example.taskmanager.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/task-manager/user/project/")
public class ProjectController {

    public final ProjectService projectService;

    //@PostMapping("")
    @GetMapping("{id}")
    public ResponseEntity get(@PathVariable Long id) {
        return ResponseEntity.ok(projectService.findOne(id));
    }

    @PostMapping("add")
    public ResponseEntity add(@RequestBody ProjectForm form) {
        return ResponseEntity.ok(projectService.add(form));
    }

    @PutMapping("update/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody ProjectForm form) {
        return ResponseEntity.ok(projectService.update(id,form));
    }

    @GetMapping("list")
    public ResponseEntity projects() {
        return ResponseEntity.ok(projectService.projects());
    }


    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        return ResponseEntity.ok(projectService.delete(id));
    }


}
