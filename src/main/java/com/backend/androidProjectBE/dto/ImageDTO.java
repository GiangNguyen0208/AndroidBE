package com.backend.androidProjectBE.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class ImageDTO {
    private int id;

    private String imgLink;
}
