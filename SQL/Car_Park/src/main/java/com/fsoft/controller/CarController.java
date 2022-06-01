package com.fsoft.controller;

import com.fsoft.config.ResponseObject;
import com.fsoft.dto.BookingOfficeDTO;
import com.fsoft.dto.CarDTO;
import com.fsoft.entity.BookingOffice;
import com.fsoft.entity.Car;
import com.fsoft.service.BookingOfficeService;
import com.fsoft.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/car")
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping("")
    public Page<CarDTO> getAllCar(Pageable pageable){
        return carService.getAllCar(pageable);
    }

    @PostMapping("/insert")
    public ResponseEntity<ResponseObject> addCar(@RequestBody Car car){
        carService.addCar(car);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert Success")
        );
    }

    @PutMapping("/update/{licensePlate}")
    public ResponseEntity<ResponseObject> updateCar(@RequestBody  Car car, @PathVariable String licensePlate){
        carService.updateCar(car,licensePlate);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","Update Success !")
        );
    }

    @DeleteMapping("/delete/{licensePlate}")
    public ResponseEntity<ResponseObject> deleteCar(@PathVariable String licensePlate){
       boolean flag = carService.deleteCarBylicensePlate(licensePlate);
        if (flag){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Delete Scucess !"));
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject  ("fail", "Find not id, please check again !"));
        }
    }
}
