package com.truckbooking.truck_booking.repository;

import com.truckbooking.truck_booking.entity.Truck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TruckRepository extends JpaRepository<Truck, Long> {
}