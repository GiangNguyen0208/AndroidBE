package com.backend.androidProjectBE.dto;

import lombok.Data;

import java.util.Date;


@Data
public class UserDTO {
    private int id;

    private String username;

    private String firstname;

    private String lastname;

    private String password;

    private Boolean gender;

    private int phone;

    private String email;

    private Date birthDay;

    private Boolean role;

    private Boolean status;

    private Date birth;
}
