package com.backend.androidProjectBE.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class OrderItemDTO {

    private int vehicleId;

    private String name;

    private double price;

    private String brand;

    private int quantity = 1;
}
