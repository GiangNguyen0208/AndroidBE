package com.backend.androidProjectBE.dto;

import lombok.Data;

import java.util.Date;


@Data
public class UserDTO {
    private Integer  id;

    private String username;

    private String firstname;

    private String lastname;

    private String password;

    private Boolean gender;

    private Integer  phone;

    private String email;

    private Date birthDay;

    private Boolean role;

    private Boolean status;

    private Date birth;

}
