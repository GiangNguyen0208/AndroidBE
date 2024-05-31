package com.backend.androidProjectBE.Controller;

import com.backend.androidProjectBE.Entity.Brands;
import com.backend.androidProjectBE.Entity.Colors;
import com.backend.androidProjectBE.Entity.Vehicles;
import com.backend.androidProjectBE.Service.imp.VehiclesServiceImp;
import com.backend.androidProjectBE.dto.RateDTO;
import com.backend.androidProjectBE.dto.VehiclesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
//@CrossOrigin("*")
@RequestMapping("/api/product")
public class VehicleController {

    @Autowired
    VehiclesServiceImp vehiclesServiceImp;

    @GetMapping("/detail")
    public ResponseEntity<?> getDetail(@RequestParam int id) {
        Vehicles vehicles = vehiclesServiceImp.findById(id);
        if (vehicles == null) {
            return new ResponseEntity<>("Vehicle not found", HttpStatus.NOT_FOUND);
        }
        VehiclesDTO vehiclesDetail = new VehiclesDTO();
        if (!vehicles.getStatus()) {
            vehiclesDetail.setPrice(vehicles.getPrice());
            vehiclesDetail.setType(vehicles.getType());
            vehiclesDetail.setId(vehicles.getId());
            if (vehicles.getDiscounts() != null) {
                vehiclesDetail.getDiscountDTO().setValue(vehicles.getDiscounts().getValue());
            }
            if (vehicles.getModels() != null) {
                vehiclesDetail.getModelDTO().setName(vehicles.getModels().getName());
            }
            if (vehicles.getImages() != null) {
                vehiclesDetail.getImageDTO().setImgLink(vehicles.getImages().getImgLink());
            }
            if (vehicles.getBrands() != null) {
                vehiclesDetail.getBrandDTO().setName(vehicles.getBrands().getName());
            }
            if (vehicles.getColors() != null) {
                vehiclesDetail.getColorDTO().setNameColor(vehicles.getColors().getNameColor());
            }
        }
        return new ResponseEntity<>(vehiclesDetail, HttpStatus.OK);
    }
    @GetMapping("")
    public ResponseEntity<?> getAllVehicle() {
        return new ResponseEntity<>(vehiclesServiceImp.getAllVehicles(), HttpStatus.OK);
    }
    @GetMapping("/brand")
    public ResponseEntity<?> getVehiclesByBrand(@RequestParam int id) {
        List<VehiclesDTO> vehiclesDTOs = vehiclesServiceImp.getVehiclesByBrand(id);
        return ResponseEntity.ok().body(vehiclesDTOs);
    }
    @GetMapping("/model")
    public ResponseEntity<?> getVehiclesByModel(@RequestParam int id) {
        List<VehiclesDTO> vehiclesDTOs = vehiclesServiceImp.getVehiclesByModel(id);
        return ResponseEntity.ok().body(vehiclesDTOs);
    }
    @GetMapping("/price")
    public ResponseEntity<?> getVehiclesByModel(@RequestParam double minPrice, @RequestParam double maxPrice) {
        List<VehiclesDTO> vehiclesDTOs = vehiclesServiceImp.getVehiclesByPrice(minPrice, maxPrice);
        return ResponseEntity.ok().body(vehiclesDTOs);
    }
}
