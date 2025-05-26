package com.example.MicroserviceImplementation.controller;

import com.example.MicroserviceImplementation.model.Subscription;
import com.example.MicroserviceImplementation.service.SubscriptionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Tag(name = "Subscriptions", description = "Subscription management APIs")
@RestController
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @PostMapping("users/{id}/subscription")
    public ResponseEntity<Subscription> addSubscription(@PathVariable Long id,
                                                        @RequestBody Subscription subscription) {
        return ResponseEntity.ok(subscriptionService.addSubscription(id, subscription));
    }

    @GetMapping("users/{id}")
    public ResponseEntity<List<Subscription>> getUserSubscriptions(@PathVariable Long id) {
        return ResponseEntity.ok(subscriptionService.getUserSubscriptions(id));
    }

    @DeleteMapping("users/{id}/subscriptions/{subId}")
    public void deleteSubscription(@PathVariable Long id, @PathVariable Long subId) {
        subscriptionService.deleteSubscription(id, subId);
    }

    @GetMapping("subscriptions/top")
    public ResponseEntity<List<Map<String, Object>>> getTop3PopularSubscriptions() {
        return ResponseEntity.ok(subscriptionService.getTop3PopularSubscriptions());
    }
}