package com.truckbooking.truck_booking.controller;

import com.truckbooking.truck_booking.entity.Assignment;
import com.truckbooking.truck_booking.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    // 🔥 Assign truck + driver to booking
    @PostMapping
    public Assignment assign(@RequestParam Long bookingId,
                             @RequestParam Long truckId,
                             @RequestParam Long driverId) {

        return assignmentService.assign(bookingId, truckId, driverId);
    }
}