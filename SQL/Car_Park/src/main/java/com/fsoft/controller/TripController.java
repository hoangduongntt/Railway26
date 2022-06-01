package com.fsoft.controller;

import com.fsoft.config.ResponseObject;
import com.fsoft.dto.BookingOfficeDTO;
import com.fsoft.dto.TripDTO;
import com.fsoft.entity.BookingOffice;
import com.fsoft.entity.Trip;
import com.fsoft.service.BookingOfficeService;
import com.fsoft.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/trip")
public class TripController {
    @Autowired
    TripService tripService;

    @GetMapping("")
    public Page<TripDTO> getAllTrip(Pageable pageable) {
        return tripService.getAllTrip(pageable);
    }

    @PostMapping("/insert")
    public ResponseEntity<ResponseObject> addTrip(@RequestBody Trip trip) {
        tripService.addTrip(trip);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert Scucess !" ));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseObject> updateTrip(@RequestBody Trip trip, @PathVariable int id) {
        tripService.updateTrip(trip, id);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","Update Sucess!"));

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseObject> deleteTrip(@PathVariable int id){
        boolean flag = tripService.deleteTripById(id);
        if (flag){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Delete Scucess !"));
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject  ("fail", "Find not id, please check again !"));
        }
    }
}
