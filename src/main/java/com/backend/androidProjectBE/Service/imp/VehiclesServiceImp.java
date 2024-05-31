package com.backend.androidProjectBE.Service.imp;

import com.backend.androidProjectBE.Entity.Brands;
import com.backend.androidProjectBE.Entity.Vehicles;
import com.backend.androidProjectBE.dto.VehiclesDTO;

import java.awt.print.Pageable;
import java.util.List;

public interface VehiclesServiceImp {
    Vehicles findById(int id);
    List<VehiclesDTO> getAllVehicles();
    List<VehiclesDTO> getVehiclesByBrand(int id);
    List<VehiclesDTO> getVehiclesByModel(int id);
    List<VehiclesDTO> getVehiclesByPrice(double minPrice, double maxPrice);

}
