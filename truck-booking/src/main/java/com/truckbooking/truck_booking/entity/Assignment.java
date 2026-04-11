package com.truckbooking.truck_booking.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "assignments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔗 One booking → one assignment
    @OneToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    // 🔗 Many assignments → one truck
    @ManyToOne
    @JoinColumn(name = "truck_id")
    private Truck truck;

    // 🔗 Many assignments → one driver
    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;
}