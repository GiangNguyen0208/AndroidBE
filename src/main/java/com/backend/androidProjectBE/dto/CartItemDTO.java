package com.backend.androidProjectBE.dto;

import com.backend.androidProjectBE.Entity.Carts;
import com.backend.androidProjectBE.Entity.Rentals;
import com.backend.androidProjectBE.Entity.Vehicles;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
public class CartItemDTO {
    private Integer id;

    private Integer vehicleid;

    private String nameVehicle;

    private String brandVehicle;

    private Date rentalDate;

    private Date returnDate;

    private Integer rental_day;

    private double price;
}
