package com.backend.androidProjectBE.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class VehiclesDTO {
    private int id;

    private String type;

    private String name;

    private Boolean status;

    private double price;

    private double discount;

    private String color;

    private String brand;

    private String model;

    private String image;

    private Date rentalDate;

    private Date returnDate;

    private String about;

    private Integer day;
}
