package com.truckbooking.truck_booking.controller;

import com.truckbooking.truck_booking.entity.Booking;
import com.truckbooking.truck_booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // ➕ Create Booking
    @PostMapping
    public Booking createBooking(@RequestBody Booking booking, Principal principal) {
        return bookingService.createBooking(booking, principal.getName());
    }

    // 📄 Get All Bookings
    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }
}