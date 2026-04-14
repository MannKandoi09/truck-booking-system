package com.truckbooking.truck_booking.controller;

import com.truckbooking.truck_booking.dto.LoginDTO;
import com.truckbooking.truck_booking.dto.UserDTO;
import com.truckbooking.truck_booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserDTO userDTO) {
        return userService.registerUser(userDTO);
    }
    @PostMapping("/login")
    public String loginUser(@RequestBody LoginDTO loginDTO) {
        return userService.loginUser(loginDTO);
    }
    @GetMapping("/test")
    public String test() {
        return "Secure API working";
    }
}