package com.example.MicroserviceImplementation.service;

import com.example.MicroserviceImplementation.model.Subscription;

import java.util.List;
import java.util.Map;

public interface SubscriptionService {

    Subscription addSubscription(Long userId, Subscription subscription);

    List<Subscription> getUserSubscriptions(Long userId);

    void deleteSubscription(Long userId, Long subscriptionId);

    List<Map<String, Object>> getTop3PopularSubscriptions();
}