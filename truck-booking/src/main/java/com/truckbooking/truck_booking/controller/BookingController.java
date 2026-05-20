package com.truckbooking.truck_booking.controller;

import com.truckbooking.truck_booking.entity.Booking;
import com.truckbooking.truck_booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "*")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // 🔥 Create Booking (TEMP FIX - no principal)
    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {

        // 🔥 Hardcoded email (for now)
        return bookingService.createBooking(booking, "jetha@gmail.com");
    }

    // Get all bookings
    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }
}