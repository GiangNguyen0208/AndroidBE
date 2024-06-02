package com.backend.androidProjectBE.dto;

import com.backend.androidProjectBE.Entity.Users;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
//@Builder
@ToString
public class CartDTO {
    private int id;

    private Users users;
}
