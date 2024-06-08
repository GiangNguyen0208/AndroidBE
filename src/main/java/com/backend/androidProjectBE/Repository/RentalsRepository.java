package com.backend.androidProjectBE.Repository;

import com.backend.androidProjectBE.Entity.Rentals;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalsRepository extends JpaRepository<Rentals, Integer> {
}
