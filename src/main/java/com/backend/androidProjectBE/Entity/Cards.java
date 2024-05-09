package com.backend.androidProjectBE.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity(name = "cards")
@Data
public class Cards {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "card_name")
    private String cardName;

    @Column(name = "expiry_date")
    private Date expiryDate;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "user_id")
    private int userId;

    @OneToMany(mappedBy = "cards")
    private Set<Payments> paymentCard;
}
