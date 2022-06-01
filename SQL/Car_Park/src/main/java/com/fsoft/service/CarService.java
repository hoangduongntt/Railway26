package com.fsoft.service;

import com.fsoft.dto.CarDTO;
import com.fsoft.entity.Car;
import com.fsoft.repository.CarRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;
    @Autowired
    ModelMapper modelMapper;

    public Page<CarDTO> getAllCar(Pageable pageable){
        Page<Car> carPage = carRepository.findAll(pageable);
        List<CarDTO> dtos = modelMapper.map(carPage.getContent(), new TypeToken<List<CarDTO>>(){}.getType());
        Page<CarDTO> carDTOPages = new PageImpl<>(dtos,pageable,carPage.getTotalElements());
        return  carDTOPages;
    }

    public CarDTO addCar(Car car){
        CarDTO dto = modelMapper.map(carRepository.save(car), CarDTO.class);
        return  dto;
    }

    public void updateCar(Car car,  String licensePlate){
        Car byLicensePlate = carRepository.findById(licensePlate).orElse(null);
        if(byLicensePlate!=null) {
            byLicensePlate.setParkinglot(car.getParkinglot());
            byLicensePlate.setCarColor(car.getCarColor());
            byLicensePlate.setCompany(car.getCompany());
            byLicensePlate.setCarType(car.getCarType());
            byLicensePlate.setParkinglot(car.getParkinglot());
            carRepository.save(byLicensePlate);
        }else {
            carRepository.save(car);
        }
    }
    @Transactional
    public boolean deleteCarBylicensePlate(String licensePlate){
        boolean isCarExist = carRepository.existsByLicensePlate(licensePlate);
        if(isCarExist){
            carRepository.deleteByLicensePlate(licensePlate);
           return true;
        }else {
            return false;
        }
    }
}
