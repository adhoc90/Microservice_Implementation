package com.example.MicroserviceImplementation.repository;

import com.example.MicroserviceImplementation.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

}
