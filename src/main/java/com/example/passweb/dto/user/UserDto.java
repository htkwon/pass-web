package com.example.passweb.dto.user;

import com.example.passweb.status.UserStatus;
import lombok.Getter;

@Getter
public class UserDto {
    private String userId;
    private String userName;
    private UserStatus status;

}
