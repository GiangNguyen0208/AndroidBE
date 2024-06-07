package com.backend.androidProjectBE.dto;

import com.backend.androidProjectBE.Entity.Rentals;
import com.backend.androidProjectBE.Entity.Vehicles;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
//@Builder
public class RentalDTO {
    private int id;

    private Date rentalDate;

    private Date returnDate;
}
