package com.example.MicroserviceImplementation.repository;

import com.example.MicroserviceImplementation.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    List<Subscription> findByUserId(Long userId);


    @Query(value = "SELECT s.serviceName, COUNT(s) as count FROM Subscription s " +
            "GROUP BY s.serviceName " +
            "ORDER BY count DESC LIMIT 3", nativeQuery = true)
    List<Object[]> findTop3PopularSubscriptions();
}