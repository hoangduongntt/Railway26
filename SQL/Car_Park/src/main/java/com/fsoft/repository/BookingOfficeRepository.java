package com.fsoft.repository;

import com.fsoft.entity.BookingOffice;
import com.fsoft.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingOfficeRepository extends JpaRepository<BookingOffice, Integer> , JpaSpecificationExecutor<BookingOffice> {
}
