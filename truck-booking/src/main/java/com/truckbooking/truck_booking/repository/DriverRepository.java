package com.truckbooking.truck_booking.repository;

import com.truckbooking.truck_booking.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}