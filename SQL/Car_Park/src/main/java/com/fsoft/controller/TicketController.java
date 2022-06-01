package com.fsoft.controller;

import com.fsoft.config.ResponseObject;
import com.fsoft.dto.TicketDTO;
import com.fsoft.entity.Ticket;
import com.fsoft.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/ticket")
public class TicketController {
    @Autowired
    TicketService ticketService;

    @GetMapping("")
    public Page<TicketDTO> getAllTicket(Pageable pageable){
        return ticketService.getAllTicket(pageable);
    }

    @PostMapping("/insert")
    public ResponseEntity<ResponseObject> addTicket(@RequestBody Ticket ticket){
        ticketService.addTicket(ticket);

        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert Sucess")
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseObject> updateTicket(@RequestBody  Ticket ticket, @PathVariable int id){
        ticketService.updateTicket(ticket,id);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","Update Success !")
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseObject> deleteTicketById(@PathVariable int id){
        boolean flag = ticketService.deleteTicketById(id);
        if (flag){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Delete Scucess !"));
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject  ("fail", "Find not id, please check again !"));
        }
    }
}
