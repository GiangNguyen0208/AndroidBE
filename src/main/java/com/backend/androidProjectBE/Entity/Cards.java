package com.backend.androidProjectBE.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity(name = "cards")
@Data
public class Cards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String cardNumber;

    private String cardName;

    private Date expiryDate;

    private String fullname;

    private int userId;

    @OneToMany(mappedBy = "cards")
    private Set<Payments> paymentCard;
}
