package com.backend.androidProjectBE.Repository;

import com.backend.androidProjectBE.Entity.Brands;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandsRepository extends JpaRepository<Brands, Integer> {
    Brands findById(int id);
}
