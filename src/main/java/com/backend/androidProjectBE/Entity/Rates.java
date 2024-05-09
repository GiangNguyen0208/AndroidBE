package com.backend.androidProjectBE.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity(name = "rates")
@Data
public class Rates {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "rateComment")
    private String rateComment;

    @Column(name = "rateScore")
    private int rateScore;

    @Column(name = "date_create")
    private Date dateCreate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicles vehicles;

}
