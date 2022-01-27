package com.example.littlebackend.controller;

import com.example.littlebackend.model.Request.LoginRequest;
import com.example.littlebackend.model.User;
import com.example.littlebackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/auth/users")
public class UserController {
    private UserService userService;
    private static final Logger LOGGER=Logger.getLogger(UserController.class.getName());
    @Autowired
    public void setUserService(UserService userService) { this.userService=userService; }
//    @Autowired
//    public UserDetailsService userDetailsService;
//
//    @PostMapping("/register")
//    public User createUser(@RequestBody User userObject){
//        LOGGER.info("calling createUser method from controller");
//        return userService.createUser(userObject);
//    }
//    @PostMapping("/login")
//    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest){
//        LOGGER.info("calling loginUser method from controller");
//        return userService.loginUser(loginRequest);
//    }

}
