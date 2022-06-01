package com.fsoft.controller;

import com.fsoft.config.ResponseObject;
import com.fsoft.dto.EmployeeDTO;
import com.fsoft.dto.ParkinglotDTO;
import com.fsoft.entity.Employee;
import com.fsoft.entity.Parkinglot;
import com.fsoft.service.EmployeeService;
import com.fsoft.service.ParkinglotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/parkinglot")
public class ParkinglotController {
    @Autowired
    ParkinglotService parkinglotService;

    @GetMapping("")
    public Page<ParkinglotDTO> getAllParkinglot(Pageable pageable){
        return parkinglotService.getAllParkinglot(pageable);
    }

    @PostMapping("/insert")
    public ResponseEntity<ResponseObject> addParkinglot(@RequestBody Parkinglot parkinglot ){
        parkinglotService.addParkinglot(parkinglot);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert Success")
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseObject> updateParkinglot(@RequestBody  Parkinglot parkinglot, @PathVariable int id){
        parkinglotService.updateParkinglot(parkinglot,id);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","Update Success !")
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseObject> deleteParkinglotById(@PathVariable int id){
       boolean flag = parkinglotService.deleteParkinglot(id);
        if (flag){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Delete Scucess !"));
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject  ("fail", "Find not id, please check again !"));
        }
    }
}
