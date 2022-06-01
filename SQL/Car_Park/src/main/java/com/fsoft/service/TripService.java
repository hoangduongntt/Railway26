package com.fsoft.service;


import com.fsoft.dto.TripDTO;
import com.fsoft.entity.Trip;
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
public class TripService {
    @Autowired
    TripRepository tripRepository;
    @Autowired
    ModelMapper modelMapper;

    public Page<TripDTO> getAllTrip(Pageable pageable){
        Page<Trip> tripPages = tripRepository.findAll(pageable);
        List<TripDTO> dtos = modelMapper.map(tripPages.getContent(), new TypeToken<List<TripDTO>>(){}.getType());
        Page<TripDTO> tripDTOPages = new PageImpl<>(dtos, pageable, tripPages.getTotalElements());
        return  tripDTOPages;
    }

    public TripDTO addTrip(Trip trip){
        TripDTO dto = modelMapper.map(tripRepository.save(trip), TripDTO.class);
        return dto;
    }

    public void updateTrip(Trip trip, int id){
            Optional<Trip> tripUpdate = Optional.of(tripRepository.findById(id).map(tr -> {
               tr.setCarType(trip.getCarType());
               tr.setBookedTicketNumber(trip.getBookedTicketNumber());
               tr.setDepartureDate(trip.getDepartureDate());
               tr.setDriver(trip.getDriver());
               tr.setDestination(trip.getDestination());
               tr.setDepartureTime(trip.getDepartureTime());
               tr.setBookedTicketNumber(trip.getBookedTicketNumber());
               tr.setMaximumOnlineTicketNumber(trip.getMaximumOnlineTicketNumber());
               tripRepository.save(tr);
               return tr;
            }).orElseGet(() -> {
                tripRepository.save(trip);
                return trip;
            }));
            System.out.println("Update Success !");
    }

    public boolean deleteTripById(int id){
        boolean isTripExist = tripRepository.existsById(id);
        if(isTripExist){
            tripRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}
