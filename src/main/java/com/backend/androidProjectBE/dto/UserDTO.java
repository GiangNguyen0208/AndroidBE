package com.backend.androidProjectBE.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Integer id;

    private String username;

    private String firstname;

    private String lastname;

    private String password;

    private String newPassword;

    private Boolean gender;

    private String phone;

    private String email;

    private Date birthDay;

    private RoleDTO roleDTO;

    private Boolean status;

    private String address;

    private String roleName;

}
