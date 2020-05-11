package com.example.clientbackend.service;

import com.example.clientbackend.dto.UserLoginDto;
import com.example.clientbackend.dto.UserRegistrationDto;
import com.example.clientbackend.model.*;
import com.example.clientbackend.repository.UserRepository;
//import com.example.agentbackend.view.UserRegisterView;
import com.example.clientbackend.security.TokenUtils;
import com.example.clientbackend.view.UserTokenState;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenUtils tokenUtils;

    public User findOneByEmailAndPassword(String email, String password) throws NotFoundException {
        User user = this.userRepository.findOneByEmail(email);
        if (!this.passwordEncoder.matches(password, user.getPassword())) {
            throw new NotFoundException("Not existing user");
        }

        return user;
    }

    public User findOneByEmail(String email) {
        return this.userRepository.findOneByEmail(email);
    }

    public User save(UserRegistrationDto user) {
        User u = User.builder().role(UserRole.valueOf("USER"))
                .firstName(user.getFirstName()).lastName(user.getLastName()).email(user.getEmail())
                .password(passwordEncoder.encode(user.getPassword())).build();

        return this.userRepository.save(u);
    }

    public UserTokenState userLogin(UserLoginDto user) throws NotFoundException {
        User u = this.findOneByEmailAndPassword(user.getEmail(), user.getPassword());
        if (u == null)
            return null;

        List<Authority> auth = this.authorityService.findAllByRoleName(u.getRole().getRole());
        final Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword(), auth));

        //ubaci username(email) + password u kontext
        SecurityContextHolder.getContext().setAuthentication(authentication);

        //Kreiraj token
        User userToken = (User) authentication.getPrincipal();
        String jwt = tokenUtils.generateToken(userToken.getEmail(), userToken.getRole().getRole());
        int expiresIn = tokenUtils.getExpiredIn();

        return new UserTokenState(jwt, (long) expiresIn, userToken.isFirstTimeLogged());
    }
}