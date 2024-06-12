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
    private int id;

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

    public UserDTO() {
        this.roleDTO = new RoleDTO();  // Khởi tạo RoleDTO
    }

    private String roleName;

}
