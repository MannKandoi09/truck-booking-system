package com.truckbooking.truck_booking.repository;

import com.truckbooking.truck_booking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}