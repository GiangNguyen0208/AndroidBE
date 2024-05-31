package com.backend.androidProjectBE.dto;

import com.backend.androidProjectBE.Entity.Users;
import com.backend.androidProjectBE.Entity.Vehicles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RateDTO {

    private String rateComment;

    private int rateScore;

    private Date dateCreate;

//    private List<UserDTO> users;

//    private List<VehiclesDTO> vehicles;
}
