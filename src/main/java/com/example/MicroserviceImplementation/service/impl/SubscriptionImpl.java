package com.example.MicroserviceImplementation.service.impl;

import com.example.MicroserviceImplementation.exception.ResourceNotFoundException;
import com.example.MicroserviceImplementation.model.Subscription;
import com.example.MicroserviceImplementation.model.User;
import com.example.MicroserviceImplementation.repository.SubscriptionRepository;
import com.example.MicroserviceImplementation.repository.UserRepository;
import com.example.MicroserviceImplementation.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubscriptionImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final UserRepository userRepository;
    private final Logger logger = LoggerFactory.getLogger(SubscriptionService.class);


    @Override
    public Subscription addSubscription(Long userId, Subscription subscription) {
        logger.info("Adding subscription for userId: {}", userId);
        User user = userRepository.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("User not found"));
        subscription.setUser(user);
        return subscriptionRepository.save(subscription);
    }

    @Override
    public List<Subscription> getUserSubscriptions(Long userId) {
        logger.info("Fetching subscriptions for userId: {}", userId);
        userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return subscriptionRepository.findByUserId(userId);
    }

    @Override
    public void deleteSubscription(Long userId, Long subscriptionId) {
        logger.info("Deleting subscription id: {} for user id: {}", subscriptionId, userId);
        Subscription subscription = subscriptionRepository.findById(subscriptionId).orElseThrow(() ->
                new ResourceNotFoundException("Subscription not found"));
        if (!subscription.getUser().getId().equals(userId)) {
            throw new ResourceNotFoundException("Subscription does not belong to user");
        }
        subscriptionRepository.delete(subscription);
    }

    @Override
    public List<Map<String, Object>> getTop3PopularSubscriptions() {
        logger.info("Fetching top 3 popular subscriptions");
        return subscriptionRepository.findTop3PopularSubscriptions().stream()
                .map(result -> Map.of(
                        "service_name", result[0],
                        "count", result[1]
                ))
                .collect(Collectors.toList());
    }
}