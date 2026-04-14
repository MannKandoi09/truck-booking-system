package com.truckbooking.truck_booking.service;

import com.truckbooking.truck_booking.entity.Booking;
import com.truckbooking.truck_booking.entity.User;
import com.truckbooking.truck_booking.repository.BookingRepository;
import com.truckbooking.truck_booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    // ➕ Create Booking
    public Booking createBooking(Booking booking, String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        booking.setUser(user);
        booking.setStatus(Booking.Status.PENDING);

        return bookingRepository.save(booking);
    }

    // 📄 Get All Bookings
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}