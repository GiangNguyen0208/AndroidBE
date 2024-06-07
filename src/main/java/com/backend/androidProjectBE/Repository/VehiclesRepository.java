package com.backend.androidProjectBE.Repository;

import com.backend.androidProjectBE.Entity.Brands;
import com.backend.androidProjectBE.Entity.Models;
import com.backend.androidProjectBE.Entity.Vehicles;
import com.backend.androidProjectBE.Service.imp.VehiclesServiceImp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface VehiclesRepository extends JpaRepository<Vehicles, Integer> {
    Vehicles findById(int id);
    List<Vehicles> findByBrands(Brands brand);
    List<Vehicles> findByModels(Models models);
    List<Vehicles> findByPriceBetween(double minPrice, double maxPrice);
    List<Vehicles> findByType(String type);
    List<Vehicles> findByNameContainingIgnoreCase(String txtSearch);

    @Query(value = "SELECT SUM(v.quantity) FROM vehicles v ", nativeQuery = true)
    Integer getQuantityInStock();

}
