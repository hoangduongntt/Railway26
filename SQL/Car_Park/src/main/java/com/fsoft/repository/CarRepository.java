package com.fsoft.repository;

import com.fsoft.entity.Car;
import com.fsoft.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {
    public boolean existsByLicensePlate(String name);
    public void deleteByLicensePlate(String name);
}
