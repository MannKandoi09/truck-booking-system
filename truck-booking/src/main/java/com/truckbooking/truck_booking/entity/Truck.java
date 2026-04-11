package com.truckbooking.truck_booking.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "trucks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Truck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String truckNumber;

    private String type;

    private Double capacity;

    @Enumerated(EnumType.STRING)
    private Availability availability;

    public enum Availability {
        AVAILABLE,
        NOT_AVAILABLE
    }
}