package com.backend.androidProjectBE.payload.request;

import lombok.Data;

@Data
public class SignupRequest {
    private String fullname;
    private String password;
    private String email;
    private int id_role;
}
