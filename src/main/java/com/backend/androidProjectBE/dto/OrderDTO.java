package com.backend.androidProjectBE.dto;

import com.backend.androidProjectBE.Entity.Payments;
import com.backend.androidProjectBE.Entity.Rentals;
import com.backend.androidProjectBE.Entity.Users;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;


@Data
@AllArgsConstructor
public class OrderDTO {

    private int id;

    private Date dateCreate;

    private Rentals rentals;

    private Users users;

    private Payments payments;
}
