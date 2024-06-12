package com.backend.androidProjectBE.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MessageDTO {
    private int id;
    private String content;
    private Integer from;
    private Integer to;
    private Date createAt;
}
