package com.example.taskmanager.controller;

import com.example.taskmanager.auth.AuthenticationResponse;
import com.example.taskmanager.auth.AuthenticationService;
import com.example.taskmanager.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/task-manager/user")
public class UserController {


    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserDto userDto)
    {
        return ResponseEntity.ok(service.register(userDto));
    }


    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody UserDto userDto)
    {
        return ResponseEntity.ok(service.authenticate(userDto));
    }

    @PostMapping("/delete")
    public ResponseEntity<Boolean> delete()
    {

        return ResponseEntity.ok(service.delete());


    }








}
