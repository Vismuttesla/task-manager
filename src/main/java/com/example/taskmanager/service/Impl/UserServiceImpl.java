package com.example.taskmanager.service.Impl;

import com.example.taskmanager.dto.UserDto;
import com.example.taskmanager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {


    @Override
    public UserDto register(String username, String email, String password) {
        return null;
    }

    @Override
    public UserDto login(String email, String password) {
        return null;
    }

    @Override
    public boolean delete() {
        return false;
    }
}
