package com.example.MicroserviceImplementation.repository;

import com.example.MicroserviceImplementation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}