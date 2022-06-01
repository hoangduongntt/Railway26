package com.fsoft.repository;

import com.fsoft.entity.Employee;
import com.fsoft.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<Trip, Integer> {
}
