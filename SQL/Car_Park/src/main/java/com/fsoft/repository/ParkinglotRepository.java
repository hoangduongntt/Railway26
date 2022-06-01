package com.fsoft.repository;

import com.fsoft.entity.Employee;
import com.fsoft.entity.Parkinglot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkinglotRepository extends JpaRepository<Parkinglot, Integer> {
}
