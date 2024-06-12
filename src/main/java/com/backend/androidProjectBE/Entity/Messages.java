package com.backend.androidProjectBE.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;
    private Date dateCreate;

    @OneToOne
    @JoinColumn(name = "from_user_id")
    private Users fromUser;
    @OneToOne
    @JoinColumn(name = "to_user_id")
    private Users toUser;
}
