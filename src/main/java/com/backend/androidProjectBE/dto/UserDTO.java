package com.backend.androidProjectBE.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

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

    private String email;

    private String password;

    private Boolean gender;

    private String  phone;

    private Date birthDay;

    private String roleName;
    private Boolean isAdminMessage;

}
