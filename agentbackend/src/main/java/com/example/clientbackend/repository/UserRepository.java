package com.example.agentbackend.repository;

import com.example.agentbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findOneByEmailAndPassword(String email, String password);
    User findOneByEmail(String email);
}
