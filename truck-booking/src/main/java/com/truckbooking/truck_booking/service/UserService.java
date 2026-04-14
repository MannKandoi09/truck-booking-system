package com.truckbooking.truck_booking.service;

import com.truckbooking.truck_booking.config.jwt.JwtUtil;
import com.truckbooking.truck_booking.dto.LoginDTO;
import com.truckbooking.truck_booking.dto.UserDTO;
import com.truckbooking.truck_booking.entity.User;
import com.truckbooking.truck_booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    // 🔐 REGISTER
    public String registerUser(UserDTO userDTO) {

        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setRole(User.Role.USER);

        userRepository.save(user);

        return "User Registered Successfully";
    }

    // 🔥 LOGIN → TOKEN RETURN
    public String loginUser(LoginDTO loginDTO) {

        User user = userRepository.findByEmail(loginDTO.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        // 🔐 Generate JWT Token
        return jwtUtil.generateToken(user.getEmail());
    }
}