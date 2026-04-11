package com.truckbooking.truck_booking.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "bookings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔗 Many bookings belong to one user
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String pickupLocation;

    private String dropLocation;

    private String loadType;

    private Double weight;

    private Double price;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        PENDING,
        APPROVED,
        IN_TRANSIT,
        DELIVERED
    }
}