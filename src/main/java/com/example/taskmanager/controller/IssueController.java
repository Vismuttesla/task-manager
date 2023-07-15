package com.example.taskmanager.controller;

import com.example.taskmanager.dto.IssueForm;
import com.example.taskmanager.service.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/task-manager/user/project/issue/")

public class IssueController {

    private final IssueService issueService;

    @GetMapping("{id}")
    public ResponseEntity get(@PathVariable Long id) {
        return ResponseEntity.ok(issueService.findOne(id));
    }



    @PostMapping("add")
    public ResponseEntity add(@RequestBody IssueForm form) {
        return ResponseEntity.ok(issueService.add(form));
    }

    @PutMapping("update/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody IssueForm form) {
        return ResponseEntity.ok(issueService.update(id, form));
    }

    @GetMapping("{projectId}/list")
    public ResponseEntity projects(@PathVariable Long projectId) {
        return ResponseEntity.ok(issueService.issues(projectId));
    }


    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        return ResponseEntity.ok(issueService.delete(id));
    }


}
