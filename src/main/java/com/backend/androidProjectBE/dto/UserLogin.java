package com.backend.androidProjectBE.dto;


import lombok.Data;

@Data
public class UserLogin {
    private int id;
    private String email;
    private String password;
    private String roles;
}
