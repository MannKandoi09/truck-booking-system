package com.truckbooking.truck_booking.controller;

import com.truckbooking.truck_booking.entity.Truck;
import com.truckbooking.truck_booking.service.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trucks")
public class TruckController {

    @Autowired
    private TruckService truckService;

    // ➕ Add Truck
    @PostMapping
    public Truck addTruck(@RequestBody Truck truck) {
        return truckService.addTruck(truck);
    }

    // 📄 Get All Trucks
    @GetMapping
    public List<Truck> getAllTrucks() {
        return truckService.getAllTrucks();
    }
}