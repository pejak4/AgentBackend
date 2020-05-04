package com.example.agentbackend.controller;

import com.example.agentbackend.view.UserLoginView;
import com.example.agentbackend.view.UserTokenState;
import com.example.agentbackend.common.TimeProvider;
import com.example.agentbackend.model.Authority;
import com.example.agentbackend.model.User;
import com.example.agentbackend.security.TokenUtils;
import com.example.agentbackend.service.CustomUserDetailsService;
import com.example.agentbackend.service.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.naming.AuthenticationException;
import java.util.List;

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
    private com.example.demo.service.AuthorityService authorityService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;



    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/login")
    public ResponseEntity<UserTokenState> login(@RequestBody UserLoginView user) throws AuthenticationException, NotFoundException {

        User u = this.userService.findOneByEmailAndPassword(user.getEmail(), user.getPassword());
        if (u == null)
            return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);

        List<Authority> auth = this.authorityService.findAllByRoleName(u.getRole().getRole());
        final Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword(), auth));

        //ubaci username(email) + password u kontext
        SecurityContextHolder.getContext().setAuthentication(authentication);

        //Kreiraj token
        User userToken = (User) authentication.getPrincipal();
        String jwt = tokenUtils.generateToken(userToken.getEmail(), userToken.getRole().getRole());
        int expiresIn = tokenUtils.getExpiredIn();

        return new ResponseEntity<>(new UserTokenState(jwt, (long) expiresIn, userToken.isFirstTimeLogged()), HttpStatus.OK);
    }
}
