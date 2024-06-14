package com.backend.androidProjectBE.Service;

import com.backend.androidProjectBE.Entity.Brands;
import com.backend.androidProjectBE.Entity.CartItems;
import com.backend.androidProjectBE.Entity.Models;
import com.backend.androidProjectBE.Entity.Vehicles;
import com.backend.androidProjectBE.Repository.BrandsRepository;
import com.backend.androidProjectBE.Repository.ModelRepository;
import com.backend.androidProjectBE.Repository.VehiclesRepository;
import com.backend.androidProjectBE.Service.imp.VehiclesServiceImp;
import com.backend.androidProjectBE.dto.CartItemDTO;
import com.backend.androidProjectBE.dto.VehiclesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
    public VehiclesDTO findById(int id) {
        Integer day = 1;
        Vehicles vehicles = vehiclesRepository.findById(id);
        Date rentalDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1); // Set return date based on quantity (days)
        Date returnDate = calendar.getTime();
        VehiclesDTO vehiclesDTO = VehiclesDTO.builder()
                .id(vehicles.getId())
                .brand(vehicles.getBrands().getName())
                .color(vehicles.getColors().getNameColor())
                .model(vehicles.getModels().getName())
                .image(vehicles.getImages().getImgLink())
                .price(vehicles.getPrice())
                .name(vehicles.getName())
                .discount(vehicles.getDiscounts().getValue())
                .type(vehicles.getType())
                .status(vehicles.getStatus())
                .rentalDate(rentalDate)
                .returnDate(returnDate)
                .desc(vehicles.getAbout())
                .day(day)
                .build();
        if (vehiclesDTO == null) {return null;} else {return vehiclesDTO;}
    }
    @Override
    public List<VehiclesDTO> getAllVehicles() {
        List<Vehicles> vehiclesList = vehiclesRepository.findAll();
        List<VehiclesDTO> vehiclesDTOList = new ArrayList<>();
        for (Vehicles vehicles : vehiclesList) {
            VehiclesDTO vehiclesDTO = new VehiclesDTO();
            vehiclesDTO.setId(vehicles.getId());
            vehiclesDTO.setName(vehicles.getName());
            vehiclesDTO.setType(vehicles.getType());
            vehiclesDTO.setPrice(vehicles.getPrice());
            vehiclesDTO.setStatus(vehicles.getStatus());
            vehiclesDTO.setColor(vehicles.getColors().getNameColor());
            vehiclesDTO.setImage(vehicles.getImages().getImgLink());
            vehiclesDTO.setBrand(vehicles.getBrands().getName());
            vehiclesDTO.setDiscount(vehicles.getDiscounts().getValue());
            vehiclesDTO.setModel(vehicles.getModels().getName());
            vehiclesDTOList.add(vehiclesDTO);
        }
        return vehiclesDTOList;
    }
    @Override
    public List<VehiclesDTO> getVehiclesByBrand(String brandName) {
        Brands brands = brandsRepository.findByName(brandName);
        List<Vehicles> listVehicleByBrandName = vehiclesRepository.findByBrands(brands);
        List<VehiclesDTO> listVehicleDTOByBrandName = new ArrayList<>();
        for (Vehicles vehicles : listVehicleByBrandName) {
            VehiclesDTO vehiclesDTO = new VehiclesDTO();
            vehiclesDTO.setId(vehicles.getId());
            vehiclesDTO.setName(vehicles.getName());
            vehiclesDTO.setType(vehicles.getType());
            vehiclesDTO.setPrice(vehicles.getPrice());
            vehiclesDTO.setStatus(vehicles.getStatus());
            vehiclesDTO.setColor(vehicles.getColors().getNameColor());
            vehiclesDTO.setImage(vehicles.getImages().getImgLink());
            vehiclesDTO.setBrand(vehicles.getBrands().getName());
            vehiclesDTO.setDiscount(vehicles.getDiscounts().getValue());
            vehiclesDTO.setModel(vehicles.getModels().getName());

            listVehicleDTOByBrandName.add(vehiclesDTO);
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
            vehiclesDTO.setName(vehicles.getName());
            vehiclesDTO.setType(vehicles.getType());
            vehiclesDTO.setPrice(vehicles.getPrice());
            vehiclesDTO.setStatus(vehicles.getStatus());
            vehiclesDTO.setColor(vehicles.getColors().getNameColor());
            vehiclesDTO.setImage(vehicles.getImages().getImgLink());
            vehiclesDTO.setBrand(vehicles.getBrands().getName());
            vehiclesDTO.setDiscount(vehicles.getDiscounts().getValue());
            vehiclesDTO.setModel(vehicles.getModels().getName());

            listVehicleDTOByModel.add(vehiclesDTO);
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
            vehiclesDTO.setName(vehicles.getName());
            vehiclesDTO.setType(vehicles.getType());
            vehiclesDTO.setPrice(vehicles.getPrice());
            vehiclesDTO.setStatus(vehicles.getStatus());
            vehiclesDTO.setColor(vehicles.getColors().getNameColor());
            vehiclesDTO.setImage(vehicles.getImages().getImgLink());
            vehiclesDTO.setBrand(vehicles.getBrands().getName());
            vehiclesDTO.setDiscount(vehicles.getDiscounts().getValue());
            vehiclesDTO.setModel(vehicles.getModels().getName());

            listVehicleDTOByPrice.add(vehiclesDTO);
        }
        return listVehicleDTOByPrice;
    }

    @Override
    public List<VehiclesDTO> getVehiclesByType(String type) {
        List<Vehicles> listVehicleByType = vehiclesRepository.findByType(type);
        List<VehiclesDTO> listVehicleDTOByType = new ArrayList<>();
        for (Vehicles vehicles : listVehicleByType) {
            VehiclesDTO vehiclesDTO = new VehiclesDTO();
            vehiclesDTO.setId(vehicles.getId());
            vehiclesDTO.setName(vehicles.getName());
            vehiclesDTO.setType(vehicles.getType());
            vehiclesDTO.setPrice(vehicles.getPrice());
            vehiclesDTO.setStatus(vehicles.getStatus());
            vehiclesDTO.setColor(vehicles.getColors().getNameColor());
            vehiclesDTO.setImage(vehicles.getImages().getImgLink());
            vehiclesDTO.setBrand(vehicles.getBrands().getName());
            vehiclesDTO.setDiscount(vehicles.getDiscounts().getValue());
            vehiclesDTO.setModel(vehicles.getModels().getName());

            listVehicleDTOByType.add(vehiclesDTO);
        }
        return listVehicleDTOByType;
    }

    @Override
    public List<VehiclesDTO> getVehiclesByTxtSearch(String txtSearch) {
        List<Vehicles> listVehicleByTxtSearch = vehiclesRepository.findByNameContainingIgnoreCase(txtSearch);
        List<VehiclesDTO> listVehicleDTOByTxtSearch = new ArrayList<>();
        for (Vehicles vehicles : listVehicleByTxtSearch) {
            VehiclesDTO vehiclesDTO = new VehiclesDTO();
            vehiclesDTO.setId(vehicles.getId());
            vehiclesDTO.setName(vehicles.getName());
            vehiclesDTO.setType(vehicles.getType());
            vehiclesDTO.setPrice(vehicles.getPrice());
            vehiclesDTO.setStatus(vehicles.getStatus());
            vehiclesDTO.setColor(vehicles.getColors().getNameColor());
            vehiclesDTO.setImage(vehicles.getImages().getImgLink());
            vehiclesDTO.setBrand(vehicles.getBrands().getName());
            vehiclesDTO.setDiscount(vehicles.getDiscounts().getValue());
            vehiclesDTO.setModel(vehicles.getModels().getName());

            listVehicleDTOByTxtSearch.add(vehiclesDTO);
        }
        return listVehicleDTOByTxtSearch;
    }


}
