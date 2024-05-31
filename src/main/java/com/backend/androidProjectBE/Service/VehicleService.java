package com.backend.androidProjectBE.Service;

import com.backend.androidProjectBE.Entity.Brands;
import com.backend.androidProjectBE.Entity.Models;
import com.backend.androidProjectBE.Entity.Vehicles;
import com.backend.androidProjectBE.Repository.BrandsRepository;
import com.backend.androidProjectBE.Repository.ModelRepository;
import com.backend.androidProjectBE.Repository.VehiclesRepository;
import com.backend.androidProjectBE.Service.imp.VehiclesServiceImp;
import com.backend.androidProjectBE.dto.VehiclesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService implements VehiclesServiceImp {
    @Autowired
    VehiclesRepository vehiclesRepository;

    @Autowired
    BrandsRepository brandsRepository;

    @Autowired
    ModelRepository modelRepository;

    @Override
    public Vehicles findById(int id) {
        Vehicles vehicles = vehiclesRepository.findById(id);
        if (vehicles == null) {return null;} else {return vehicles;}
    }
    @Override
    public List<VehiclesDTO> getAllVehicles() {
        List<Vehicles> vehiclesList = vehiclesRepository.findAll();
        List<VehiclesDTO> vehiclesDTOList = new ArrayList<>();
        for (Vehicles vehicles : vehiclesList) {
            VehiclesDTO vehiclesDTO = new VehiclesDTO();
            vehiclesDTO.setId(vehicles.getId());
            vehiclesDTO.setType(vehicles.getType());
            vehiclesDTO.setPrice(vehicles.getPrice());
            vehiclesDTO.setStatus(vehicles.getStatus());
            vehiclesDTO.getColorDTO().setNameColor(vehicles.getColors().getNameColor());
            vehiclesDTO.getImageDTO().setImgLink(vehicles.getImages().getImgLink());
            vehiclesDTO.getBrandDTO().setName(vehicles.getBrands().getName());
            vehiclesDTO.getDiscountDTO().setValue(vehicles.getDiscounts().getValue());
            vehiclesDTO.getModelDTO().setName(vehicles.getModels().getName());

            vehiclesDTOList.add(vehiclesDTO);
        }
        return vehiclesDTOList;
    }
    @Override
    public List<VehiclesDTO> getVehiclesByBrand(int id) {
        Brands brands = brandsRepository.findById(id);
        List<Vehicles> listVehicleByBrandName = vehiclesRepository.findByBrands(brands);
        List<VehiclesDTO> listVehicleDTOByBrandName = new ArrayList<>();
        for (Vehicles vehicles : listVehicleByBrandName) {
            VehiclesDTO vehiclesDTO = new VehiclesDTO();
            vehiclesDTO.setId(vehicles.getId());
            vehiclesDTO.setType(vehicles.getType());
            vehiclesDTO.setPrice(vehicles.getPrice());
            vehiclesDTO.setStatus(vehicles.getStatus());
            vehiclesDTO.getColorDTO().setNameColor(vehicles.getColors().getNameColor());
            vehiclesDTO.getImageDTO().setImgLink(vehicles.getImages().getImgLink());
            vehiclesDTO.getBrandDTO().setName(vehicles.getBrands().getName());
            vehiclesDTO.getDiscountDTO().setValue(vehicles.getDiscounts().getValue());
            vehiclesDTO.getModelDTO().setName(vehicles.getModels().getName());
        }
        return listVehicleDTOByBrandName;
    }
    @Override
    public List<VehiclesDTO> getVehiclesByModel(int id) {
        Models models = modelRepository.findById(id);
        List<Vehicles> listVehicleByModel = vehiclesRepository.findByModels(models);
        List<VehiclesDTO> listVehicleDTOByModel = new ArrayList<>();
        for (Vehicles vehicles : listVehicleByModel) {
            VehiclesDTO vehiclesDTO = new VehiclesDTO();
            vehiclesDTO.setId(vehicles.getId());
            vehiclesDTO.setType(vehicles.getType());
            vehiclesDTO.setPrice(vehicles.getPrice());
            vehiclesDTO.setStatus(vehicles.getStatus());
            vehiclesDTO.getColorDTO().setNameColor(vehicles.getColors().getNameColor());
            vehiclesDTO.getImageDTO().setImgLink(vehicles.getImages().getImgLink());
            vehiclesDTO.getBrandDTO().setName(vehicles.getBrands().getName());
            vehiclesDTO.getDiscountDTO().setValue(vehicles.getDiscounts().getValue());
            vehiclesDTO.getModelDTO().setName(vehicles.getModels().getName());
        }
        return listVehicleDTOByModel;
    }

    @Override
    public List<VehiclesDTO> getVehiclesByPrice(double minPrice, double maxPrice) {
        List<Vehicles> listVehicleByPrice = vehiclesRepository.findByPriceBetween(minPrice, maxPrice);
        List<VehiclesDTO> listVehicleDTOByPrice = new ArrayList<>();
        for (Vehicles vehicles : listVehicleByPrice) {
            VehiclesDTO vehiclesDTO = new VehiclesDTO();
            vehiclesDTO.setId(vehicles.getId());
            vehiclesDTO.setType(vehicles.getType());
            vehiclesDTO.setPrice(vehicles.getPrice());
            vehiclesDTO.setStatus(vehicles.getStatus());
            vehiclesDTO.getColorDTO().setNameColor(vehicles.getColors().getNameColor());
            vehiclesDTO.getImageDTO().setImgLink(vehicles.getImages().getImgLink());
            vehiclesDTO.getBrandDTO().setName(vehicles.getBrands().getName());
            vehiclesDTO.getDiscountDTO().setValue(vehicles.getDiscounts().getValue());
            vehiclesDTO.getModelDTO().setName(vehicles.getModels().getName());
        }
        return listVehicleDTOByPrice;
    }
}
