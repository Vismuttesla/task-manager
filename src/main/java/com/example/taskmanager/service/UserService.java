package com.example.taskmanager.service;

import com.example.taskmanager.dto.UserDto;
import org.springframework.stereotype.Service;


public interface UserService {

    UserDto register(String username,String email, String password);
    UserDto login(String email,String password);

    boolean delete();

}
