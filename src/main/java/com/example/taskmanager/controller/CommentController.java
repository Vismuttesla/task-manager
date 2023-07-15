package com.example.taskmanager.controller;

import com.example.taskmanager.dto.CommentForm;
import com.example.taskmanager.repository.CommentRepository;
import com.example.taskmanager.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/task-manager/user/project/issue/comment")


public class CommentController {
   private final CommentService commentService;

    @PostMapping("add")
    public ResponseEntity add(@RequestBody CommentForm form)
    {


        return ResponseEntity.ok(commentService.add(form));

    }

    @GetMapping("list/{issueId}")
    public ResponseEntity comments(@PathVariable Long issueId) {
        return ResponseEntity.ok(commentService.comments(issueId));


    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable Long id,@RequestBody CommentForm form) {
        return ResponseEntity.ok(commentService.update(id,form));

    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id ){
        return ResponseEntity.ok(commentService.delete(id));

    }

}
