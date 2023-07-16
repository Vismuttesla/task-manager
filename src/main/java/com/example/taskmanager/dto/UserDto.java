package com.example.taskmanager.dto;

import com.example.taskmanager.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {
    private  String userName;
    private String email;
    private String password;

    public static UserDto fromUser(User user)
    {


    return new UserDtoBuilder().userName(user.getUsername())
            .email(user.getEmail())
            .password(user.getPassword()).build();
    }


}
