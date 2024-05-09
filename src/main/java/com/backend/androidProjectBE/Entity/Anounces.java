package com.backend.androidProjectBE.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity(name = "anounces")
@Data
public class Anounces {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "send_at")
    private Date sendAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;
}
