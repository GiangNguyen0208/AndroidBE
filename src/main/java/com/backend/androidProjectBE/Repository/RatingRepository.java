package com.backend.androidProjectBE.Repository;

import com.backend.androidProjectBE.Entity.Rates;
import com.backend.androidProjectBE.Entity.Users;
import com.backend.androidProjectBE.Entity.Vehicles;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rates, Integer> {

    List<Rates> findByVehicles(Vehicles vehicles);
    List<Rates> findByUsers(Users user);

}
