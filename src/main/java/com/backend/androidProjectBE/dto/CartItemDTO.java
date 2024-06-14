package com.backend.androidProjectBE.dto;

import com.backend.androidProjectBE.Entity.Carts;
import com.backend.androidProjectBE.Entity.Rentals;
import com.backend.androidProjectBE.Entity.Vehicles;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDTO {
    private Integer id;

    private int vehicleid;

    private String nameVehicle;

    private String brandVehicle;

    private String imageLink;

    private Date rentalDate;

    private Date returnDate;

    private Integer rental_day;

    private double price;

    private Integer day;

    private String address;

    private String email;

    private String phone;

    private int userid;
}
