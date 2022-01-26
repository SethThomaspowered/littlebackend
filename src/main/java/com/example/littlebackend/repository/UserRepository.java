package com.example.littlebackend.repository;

import com.example.littlebackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // to regisiter
    boolean existsByEmail(String userEmail);

    // to login
    User findUserByEmail(String userEmail);
}
