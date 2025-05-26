package com.example.MicroserviceImplementation.service;

import com.example.MicroserviceImplementation.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    User getUserById(Long id);

    User updateUser(Long id, User userDetails);

    void deleteUser(Long id);

    List<User> getAllUsers();
}