package com.example.MicroserviceImplementation.dto;

import com.example.MicroserviceImplementation.model.Subscription;

import java.time.LocalDate;

public record SubscriptionDto(Long id, String name, LocalDate startDate, Long userId) {
    public static SubscriptionDto fromSubscription(Subscription subscription) {
        return new SubscriptionDto(
                subscription.getId(),
                subscription.getName(),
                subscription.getStartDate(),
                subscription.getUser().getId()
        );
    }
}