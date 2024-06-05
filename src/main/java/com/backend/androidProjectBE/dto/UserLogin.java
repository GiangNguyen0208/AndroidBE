package com.backend.androidProjectBE.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserLogin {
    private String email;
    private String password;
    private Integer role;

}
