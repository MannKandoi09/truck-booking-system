package com.truckbooking.truck_booking.service;

import com.truckbooking.truck_booking.entity.Truck;
import com.truckbooking.truck_booking.repository.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TruckService {

    @Autowired
    private TruckRepository truckRepository;

    // ➕ Add Truck
    public Truck addTruck(Truck truck) {
        return truckRepository.save(truck);
    }

    // 📄 Get All Trucks
    public List<Truck> getAllTrucks() {
        return truckRepository.findAll();
    }
}