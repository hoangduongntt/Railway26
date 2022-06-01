package com.fsoft.service;

import com.fsoft.dto.TicketDTO;
import com.fsoft.dto.TripDTO;
import com.fsoft.entity.Car;
import com.fsoft.entity.Ticket;
import com.fsoft.entity.Trip;
import com.fsoft.repository.CarRepository;
import com.fsoft.repository.TicketRepository;
import com.fsoft.repository.TripRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    ModelMapper modelMapper;


    public Page<TicketDTO> getAllTicket(Pageable pageable){
        Page<Ticket> tripList = ticketRepository.findAll(pageable);
        List<TicketDTO> dtos = modelMapper.map(tripList.getContent(), new TypeToken<List<TicketDTO>>(){}.getType());
        Page<TicketDTO> ticketDTOPages = new PageImpl<>(dtos,pageable, tripList.getTotalElements());
        return  ticketDTOPages;
    }

    public TicketDTO addTicket(Ticket ticket){
        TicketDTO dto = modelMapper.map(ticketRepository.save(ticket), TicketDTO.class);
        return  dto;
    }

    public void updateTicket(Ticket ticket, int id){
            Optional<Ticket> ticketUpdate = Optional.of(ticketRepository.findById(id).map(tic -> {
              tic.setCustomerName(ticket.getCustomerName());
              tic.setTrip(ticket.getTrip());
              tic.setCar(ticket.getCar());
              tic.setBookingTime(ticket.getBookingTime());
              ticketRepository.save(tic);
               return tic;
            }).orElseGet(() -> {
                ticketRepository.save(ticket);
                return ticket;
            }));
            System.out.println("Update Success !");

    }

    public boolean deleteTicketById(int id){
        boolean isTicketExist = ticketRepository.existsById(id);
        if(isTicketExist){
            ticketRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}
