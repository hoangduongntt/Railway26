package com.fsoft.service;

import com.fsoft.dto.EmployeeDTO;
import com.fsoft.dto.ParkinglotDTO;
import com.fsoft.entity.Employee;
import com.fsoft.entity.Parkinglot;
import com.fsoft.repository.EmployeeRepository;
import com.fsoft.repository.ParkinglotRepository;
import org.aspectj.weaver.NewConstructorTypeMunger;
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
public class ParkinglotService {
    @Autowired
    ParkinglotRepository parkinglotRepository;
    @Autowired
    ModelMapper modelMapper;

    public Page<ParkinglotDTO> getAllParkinglot(Pageable pageable){
        Page<Parkinglot> parkinglotPage = parkinglotRepository.findAll(pageable);
        List<ParkinglotDTO> dtos = modelMapper.map(parkinglotPage.getContent(), new TypeToken<List<ParkinglotDTO>>(){}.getType());
        Page<ParkinglotDTO> parkinglotDTOPages = new PageImpl<>(dtos,pageable,parkinglotPage.getTotalElements());
        return  parkinglotDTOPages;
    }

    public ParkinglotDTO addParkinglot(Parkinglot parkinglot){
        ParkinglotDTO dto = modelMapper.map(parkinglotRepository.save(parkinglot), ParkinglotDTO.class);
        return  dto;
    }

    public void updateParkinglot(Parkinglot parkinglot, int id){
            Optional<Parkinglot> parkinglotUpdate = Optional.of(parkinglotRepository.findById(id).map(park -> {
               park.setParkArea(parkinglot.getParkArea());
               park.setParkName(parkinglot.getParkName());
               park.setParkPlace(parkinglot.getParkPlace());
               park.setParkPrice(parkinglot.getParkPrice());
               park.setParkStatus(parkinglot.getParkStatus());
               parkinglotRepository.save(park);
                return park;
            }).orElseGet(() -> {
                parkinglotRepository.save(parkinglot);
                return parkinglot;
            }));
            System.out.println("Update Success !");
    }

    public boolean deleteParkinglot(int id){
        boolean isParkinglotExist = parkinglotRepository.existsById(id);
        if(isParkinglotExist){
            parkinglotRepository.deleteById(id);
           return true;
        }else {
            return  false;
        }
    }
}
