package com.fsoft.service;

import com.fsoft.dto.BookingOfficeDTO;
import com.fsoft.entity.BookingOffice;
import com.fsoft.repository.BookingOfficeRepository;
import com.fsoft.specification.BookingOfficeSpecification;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingOfficeService {
    @Autowired
    BookingOfficeRepository bookingOfficeRepository;
    @Autowired
    ModelMapper modelMapper;

    public Page<BookingOfficeDTO> getAllBookingOffice(Pageable pageable, String search){
        Specification<BookingOffice> where = BookingOfficeSpecification.buidWhere(search);
        Page<BookingOffice> bookingOfficePages = bookingOfficeRepository.findAll(where,pageable);
        List<BookingOfficeDTO> dtos = modelMapper.map(bookingOfficePages.getContent(), new TypeToken<List<BookingOfficeDTO>>(){}.getType());
        Page<BookingOfficeDTO> bookingOfficeDTOPage = new PageImpl<>(dtos,pageable,bookingOfficePages.getTotalElements());
        return  bookingOfficeDTOPage;
    }

    public BookingOfficeDTO addBookingOffice(BookingOffice bookingOffice){
        BookingOfficeDTO dto = modelMapper.map(bookingOfficeRepository.save(bookingOffice), BookingOfficeDTO.class);
        return dto;
    }

    public void updateBookingOffice(BookingOffice bookingOffice,  int id){
            Optional<BookingOffice> bookingOfficeUpdate = Optional.of(bookingOfficeRepository.findById(id).map(booking -> {
                booking.setOfficeName(bookingOffice.getOfficeName());
                booking.setOfficePhone(bookingOffice.getOfficePhone());
                booking.setOfficePlace(bookingOffice.getOfficePlace());
                booking.setOfficePrice(bookingOffice.getOfficePrice());
                booking.setStartContractDealine(bookingOffice.getStartContractDealine());
                booking.setEndContractDealine(bookingOffice.getEndContractDealine());
                bookingOfficeRepository.save(booking);
                return booking;
            }).orElseGet(() -> {
                bookingOfficeRepository.save(bookingOffice);
                return bookingOffice;
            }));
    }

    public boolean deleteBookingOfficeById(int id){
        boolean isBookingOfficeExist = bookingOfficeRepository.existsById(id);
        if(isBookingOfficeExist){
            bookingOfficeRepository.deleteById(id);
            return  true;
        }else {
            return  false;
        }
    }
}
