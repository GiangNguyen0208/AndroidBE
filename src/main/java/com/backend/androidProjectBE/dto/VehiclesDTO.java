package com.backend.androidProjectBE.dto;

import lombok.*;

import java.util.List;

@Data
//@Builder
@ToString
public class VehiclesDTO {
    private int id;

    private String type;

    private String name;

    private Boolean status;

    private double price;

    private DiscountDTO discountDTO;

    private ColorDTO colorDTO;

    private BrandDTO brandDTO;

    private ModelDTO modelDTO;

    private ImageDTO imageDTO;
    public VehiclesDTO() {
        this.discountDTO = new DiscountDTO();
        this.modelDTO = new ModelDTO();
        this.imageDTO = new ImageDTO();
        this.brandDTO = new BrandDTO();
        this.colorDTO = new ColorDTO();
    }
}
