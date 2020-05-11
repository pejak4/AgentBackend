package com.example.clientbackend.repository;

import com.example.clientbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findOneByEmailAndPassword(String email, String password);
    User findOneByEmail(String email);
}
