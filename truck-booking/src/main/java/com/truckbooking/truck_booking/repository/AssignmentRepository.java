package com.truckbooking.truck_booking.repository;

import com.truckbooking.truck_booking.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
}