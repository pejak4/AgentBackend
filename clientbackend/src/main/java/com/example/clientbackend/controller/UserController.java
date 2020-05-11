package com.example.clientbackend.controller;

import com.example.clientbackend.dto.UserCheckEmailDTO;
import com.example.clientbackend.dto.UserLoginDto;
import com.example.clientbackend.dto.UserRegistrationDto;
import com.example.clientbackend.model.User;
import com.example.clientbackend.service.AuthorityService;
import com.example.clientbackend.view.UserTokenState;
import com.example.clientbackend.common.TimeProvider;
import com.example.clientbackend.security.TokenUtils;
import com.example.clientbackend.service.CustomUserDetailsService;
import com.example.clientbackend.service.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import javax.naming.AuthenticationException;

@RestController
public class UserController {

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private TimeProvider timeProvider;

    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;


    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/login")
    public ResponseEntity<UserTokenState> login(@RequestBody UserLoginDto user) throws NotFoundException {
        return new ResponseEntity<>(this.userService.userLogin(user), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/registration")
    public ResponseEntity<?> registration(@RequestBody UserRegistrationDto user) {
        return new ResponseEntity<>(this.userService.save(user), HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/email-check")
    public ResponseEntity<?> checkEmail(@RequestBody UserCheckEmailDTO user){
        return new ResponseEntity<>(this.userService.checkEmail(user.getEmail()), HttpStatus.OK);
    }
}
