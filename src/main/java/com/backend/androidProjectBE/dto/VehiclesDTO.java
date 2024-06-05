package com.backend.androidProjectBE.dto;

import lombok.*;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.util.List;

@Data
//@Builder
@ToString
public class VehiclesDTO {
    private int id;

    private String type;

    private String name;

    private String about;

    private Boolean status;

    private double price;

    private double discount;

    private String colorName;

    private String brandName;

    private String model;

    private String imageUrl;

    public VehiclesDTO() {
    }

}
