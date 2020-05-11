package com.example.clientbackend.controller;

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
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

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
    public ResponseEntity<UserTokenState> login(@RequestBody UserLoginDto user) throws AuthenticationException, NotFoundException {

        UserTokenState uts = userService.userLogin(user);

        if (uts == null)
            return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);

        return new ResponseEntity<>(uts, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/registration")
    public ResponseEntity<UserTokenState> registration(@RequestBody UserRegistrationDto user) throws NotFoundException {

        userService.save(user);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/email-check")
    public ResponseEntity<?> checkEmail(@RequestBody String email){

        User u = userService.findOneByEmail(email);

        Boolean checkEmail;
        if (u == null)
            checkEmail = false;
        else
            checkEmail = true;

        return new ResponseEntity<>(checkEmail, HttpStatus.OK);
    }
}
