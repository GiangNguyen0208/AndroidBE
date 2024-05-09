package com.backend.androidProjectBE.payload;

import lombok.Data;

@Data
public class ResponseData {
    private int status;
    private String desc;
    private Object data;
}
