package com.backend.androidProjectBE.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.androidProjectBE.Entity.LicenseVehicles;

public interface LicenseVehiclesRepository extends JpaRepository<LicenseVehicles, Integer>{
    
}
