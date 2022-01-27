package com.example.littlebackend.service;

import com.example.littlebackend.exception.InformationExistsException;
import com.example.littlebackend.model.Request.LoginRequest;
import com.example.littlebackend.model.Response.LoginResponse;
import com.example.littlebackend.model.User;
import com.example.littlebackend.repository.UserRepository;
import com.example.littlebackend.security.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class UserService {
    private UserRepository userRepository;
    private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());

//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    private JWTUtils jwtUtils;
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
    @Autowired
    private void setUserRepository(UserRepository userRepository) { this.userRepository=userRepository;}

//    public User createUser(User userObject){
//        LOGGER.info("calling createUser from service");
//        if (!userRepository.existsByEmail(userObject.getEmail())){
//            userObject.setPassword(passwordEncoder.encode(userObject.getPassword()));
//            return userRepository.save(userObject);
//        }else{
//            throw new InformationExistsException("user with email address " +
//                    userObject.getEmail() + " already exists");
//        }
//    }
//    public ResponseEntity<?> loginUser(LoginRequest loginRequest) {
//        LOGGER.info("service calling loginUser ==>");
//        authenticationManager.authenticate(new
//                UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
//        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());
//        final String JWT = jwtUtils.generateToken(userDetails);
//        return ResponseEntity.ok(new LoginResponse(JWT));
//    }
    public User findUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }
}
