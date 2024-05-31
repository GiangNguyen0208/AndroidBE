package com.backend.androidProjectBE.Repository;

import com.backend.androidProjectBE.Entity.Brands;
import com.backend.androidProjectBE.Entity.Models;
import com.backend.androidProjectBE.Entity.Vehicles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface VehiclesRepository extends JpaRepository<Vehicles, Integer> {
    Vehicles findById(int id);
    List<Vehicles> findByBrands(Brands brand);
    List<Vehicles> findByModels(Models models);
    List<Vehicles> findByPriceBetween(double minPrice, double maxPrice);

}
