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
    public VehiclesDTO findById(int id) {
        Vehicles vehicles = vehiclesRepository.findById(id);
        if (vehicles == null) {
            return null;
        } else {
            return map(vehicles);
        }
    }

    @Override
    public List<VehiclesDTO> getAllVehicles() {
        List<Vehicles> vehiclesList = vehiclesRepository.findAll();
        List<VehiclesDTO> vehiclesDTOList = new ArrayList<>();
        for (Vehicles vehicles : vehiclesList) {
            VehiclesDTO vehiclesDTO = map(vehicles);

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
            VehiclesDTO vehiclesDTO = map(vehicles);

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
            VehiclesDTO vehiclesDTO = map(vehicles);

            listVehicleDTOByModel.add(vehiclesDTO);
        }
        return listVehicleDTOByModel;
    }

    @Override
    public List<VehiclesDTO> getVehiclesByPrice(double minPrice, double maxPrice) {
        List<Vehicles> listVehicleByPrice = vehiclesRepository.findByPriceBetween(minPrice, maxPrice);
        List<VehiclesDTO> listVehicleDTOByPrice = new ArrayList<>();
        for (Vehicles vehicles : listVehicleByPrice) {
            VehiclesDTO vehiclesDTO = map(vehicles);

            listVehicleDTOByPrice.add(vehiclesDTO);
        }
        return listVehicleDTOByPrice;
    }

    @Override
    public List<VehiclesDTO> getVehiclesByType(String type) {
        List<Vehicles> listVehicleByType = vehiclesRepository.findByType(type);
        List<VehiclesDTO> listVehicleDTOByType = new ArrayList<>();
        for (Vehicles vehicles : listVehicleByType) {
            VehiclesDTO vehiclesDTO = map(vehicles);
            listVehicleDTOByType.add(vehiclesDTO);
        }
        return listVehicleDTOByType;
    }

    @Override
    public List<VehiclesDTO> getVehiclesByTxtSearch(String txtSearch) {
        List<Vehicles> listVehicleByTxtSearch = vehiclesRepository.findByNameContainingIgnoreCase(txtSearch);
        List<VehiclesDTO> listVehicleDTOByTxtSearch = new ArrayList<>();
        for (Vehicles vehicles : listVehicleByTxtSearch) {
            VehiclesDTO vehiclesDTO = map(vehicles);
            listVehicleDTOByTxtSearch.add(vehiclesDTO);
        }
        return listVehicleDTOByTxtSearch;
    }

    private VehiclesDTO map(Vehicles object) {
        VehiclesDTO result = new VehiclesDTO();
        result.setId(object.getId());
        result.setType(object.getType());
        result.setName(object.getName());
        result.setPrice(object.getPrice());
        result.setStatus(object.getStatus());
        result.setDiscount(object.getDiscounts().getValue());
        result.setColorName(object.getColors().getNameColor());
        result.setImageUrl(object.getImages().getImgLink());
        result.setBrandName(object.getBrands().getName());
        result.setModel(object.getModels().getName());
        return result;
    }
}
