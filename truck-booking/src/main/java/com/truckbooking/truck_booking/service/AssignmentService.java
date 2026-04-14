package com.truckbooking.truck_booking.service;

import com.truckbooking.truck_booking.entity.Assignment;
import com.truckbooking.truck_booking.entity.Booking;
import com.truckbooking.truck_booking.entity.Driver;
import com.truckbooking.truck_booking.entity.Truck;
import com.truckbooking.truck_booking.repository.AssignmentRepository;
import com.truckbooking.truck_booking.repository.BookingRepository;
import com.truckbooking.truck_booking.repository.DriverRepository;
import com.truckbooking.truck_booking.repository.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private TruckRepository truckRepository;

    @Autowired
    private DriverRepository driverRepository;

    public Assignment assign(Long bookingId, Long truckId, Long driverId) {

        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        Truck truck = truckRepository.findById(truckId)
                .orElseThrow(() -> new RuntimeException("Truck not found"));

        Driver driver = driverRepository.findById(driverId)
                .orElseThrow(() -> new RuntimeException("Driver not found"));

        Assignment assignment = new Assignment();
        assignment.setBooking(booking);
        assignment.setTruck(truck);
        assignment.setDriver(driver);

        // 🔥 Update status
        booking.setStatus(Booking.Status.APPROVED);

        return assignmentRepository.save(assignment);
    }
}