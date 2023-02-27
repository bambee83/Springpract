package com.sparta.springmvc;

import lombok.Getter;

import javax.persistence.Column;
@Getter
public class UserRequestDto {
    private String username;

    private String password;

    private String email;
}
