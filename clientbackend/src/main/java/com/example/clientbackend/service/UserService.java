package com.example.clientbackend.service;

import com.example.clientbackend.model.*;
import com.example.clientbackend.repository.UserRepository;
//import com.example.agentbackend.view.UserRegisterView;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User findOneByEmailAndPassword(String email, String password) throws NotFoundException {
        User user = this.userRepository.findOneByEmail(email);
        if (!this.passwordEncoder.matches(password, user.getPassword()))
            throw new NotFoundException("Not existing user");

        return user;
    }

    public User findOneByEmail(String email) {
        return this.userRepository.findOneByEmail(email);
    }

//    public User save(UserRegisterView user) {
//        User u = Users.builder().role(UserRole.valueOf("USER"))
//                .firstName(user.getFirstName()).lastName(user.getLastName()).email(user.getEmail())
//                .password(passwordEncoder.encode(user.getPassword())).build();
//
//        return this.userRepository.save(u);
//    }
}