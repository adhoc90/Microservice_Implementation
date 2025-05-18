package com.example.MicroserviceImplementation.dto;

import com.example.MicroserviceImplementation.model.User;

import java.time.LocalDateTime;

public record UserDto(Long id, String name, String email, LocalDateTime createdAt) {
    public static UserDto fromUser(User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreatedAt()
        );
    }
}