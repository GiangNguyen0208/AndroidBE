package com.backend.androidProjectBE.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MessageDTO {
    private int id;
    private String content, fromFirstName, toFirstName;
    private Integer from, to;
    private Date createAt;
}
