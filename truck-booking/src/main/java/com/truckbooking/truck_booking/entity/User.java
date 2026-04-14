package com.truckbooking.truck_booking.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role {
        ADMIN,
        USER
    }
}

//eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqZXRoYUBnbWFpbC5jb20iLCJpYXQiOjE3NzU4OTA4MjYsImV4cCI6MTc3NTg5NDQyNn0.6pfeD1ZuFPHSzTjaw5sMB7n-tCxS96Qu3_EnlZ9EUsk