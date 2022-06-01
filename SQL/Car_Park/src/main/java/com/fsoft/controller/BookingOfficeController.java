package com.fsoft.controller;

import com.fsoft.config.ResponseObject;
import com.fsoft.dto.BookingOfficeDTO;
import com.fsoft.entity.BookingOffice;
import com.fsoft.service.BookingOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/bookingOffice")
public class BookingOfficeController {
    @Autowired
    BookingOfficeService bookingOfficeService;

    @GetMapping("")
    public Page<BookingOfficeDTO> getAllBookingOffice(Pageable pageable, @RequestParam(value = "search", required = false) String search){
        return bookingOfficeService.getAllBookingOffice(pageable,search);
    }

    @PostMapping("/insert")
    public ResponseEntity<ResponseObject> addBookingOffice(@RequestBody BookingOffice bookingOffice){
        bookingOfficeService.addBookingOffice(bookingOffice);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert Success")
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseObject> updateBookingOffice(@RequestBody  BookingOffice bookingOffice, @PathVariable int id){
        bookingOfficeService.updateBookingOffice(bookingOffice,id);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","Update Success !")
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseObject> deleteBookingOfficeById(@PathVariable int id){
        boolean flag = bookingOfficeService.deleteBookingOfficeById(id);
        if (flag){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Delete Scucess !"));
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject  ("fail", "Find not id, please check again !"));
        }
    }
}
