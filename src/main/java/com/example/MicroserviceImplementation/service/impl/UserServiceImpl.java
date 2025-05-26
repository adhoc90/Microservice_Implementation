package com.example.MicroserviceImplementation.service.impl;

import com.example.MicroserviceImplementation.model.User;
import com.example.MicroserviceImplementation.repository.UserRepository;
import com.example.MicroserviceImplementation.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User createUser(User user) {
        logger.info("Creating new user: {}", user.getEmail());
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        logger.info("Fetching user by id: {}", id);
        return userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("User not found"));
    }

    @Override
    public User updateUser(Long id, User userDetails) {
        logger.info("Updating user with id: {}", id);
        User user = getUserById(id);
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        logger.info("Deleting user with id: {}", id);
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}