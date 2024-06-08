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
@RequestMapping("/api/v1")
public class VehicleController {

    @Autowired
    VehiclesServiceImp vehiclesServiceImp;

    @GetMapping("/product/detail")
    public ResponseEntity<?> getDetail(@RequestParam int id) {
        VehiclesDTO vehicles = vehiclesServiceImp.findById(id);
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }
    @GetMapping("/product")
    public ResponseEntity<?> getAllVehicle() {
        return new ResponseEntity<>(vehiclesServiceImp.getAllVehicles(), HttpStatus.OK);
    }
    @GetMapping("/product/brand")
    public ResponseEntity<?> getVehiclesByBrand(@RequestParam String brandName) {
        List<VehiclesDTO> vehiclesDTOs = vehiclesServiceImp.getVehiclesByBrand(brandName);
        return ResponseEntity.ok().body(vehiclesDTOs);
    }
    @GetMapping("/product/model")
    public ResponseEntity<?> getVehiclesByModel(@RequestParam int id) {
        List<VehiclesDTO> vehiclesDTOs = vehiclesServiceImp.getVehiclesByModel(id);
        return ResponseEntity.ok().body(vehiclesDTOs);
    }
    @GetMapping("/product/price")
    public ResponseEntity<?> getVehiclesByModel(@RequestParam double minPrice, @RequestParam double maxPrice) {
        List<VehiclesDTO> vehiclesDTOs = vehiclesServiceImp.getVehiclesByPrice(minPrice, maxPrice);
        return ResponseEntity.ok().body(vehiclesDTOs);
    }
    @GetMapping("/product/type")
    public ResponseEntity<?> getVehiclesByModel(@RequestParam String type) {
        List<VehiclesDTO> vehiclesDTOs = vehiclesServiceImp.getVehiclesByType(type);
        return ResponseEntity.ok().body(vehiclesDTOs);
    }
    @GetMapping("/product/search")
    public ResponseEntity<?> getVehiclesByTxtSearch(@RequestParam String txtSearch) {
        List<VehiclesDTO> vehiclesDTOs = vehiclesServiceImp.getVehiclesByTxtSearch(txtSearch);
        return ResponseEntity.ok().body(vehiclesDTOs);
    }
}
