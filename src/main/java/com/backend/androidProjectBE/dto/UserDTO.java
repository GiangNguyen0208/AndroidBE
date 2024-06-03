package com.backend.androidProjectBE.dto;

import lombok.Data;

import java.util.Date;


@Data
public class UserDTO {
    private Integer  id;

    private String firstname;

    private String lastname;

    private String email;

    private String password;

    private Boolean gender;

    private Integer  phone;

    private Date birthDay;

}
