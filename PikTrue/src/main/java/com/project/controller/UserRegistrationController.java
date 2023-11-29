package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.mapper.UserRepository;
import com.project.model.User;

@RestController
public class UserRegistrationController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public String registerUser(@RequestParam("username") String username, @RequestParam("password") String password) {
    	
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        
        userRepository.save(user);
        
        return "User registered successfully!";
    }
}
