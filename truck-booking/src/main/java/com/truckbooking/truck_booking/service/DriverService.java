package com.truckbooking.truck_booking.service;

import com.truckbooking.truck_booking.entity.Driver;
import com.truckbooking.truck_booking.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    // ➕ Add Driver
    public Driver addDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    // 📄 Get All Drivers
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }
}