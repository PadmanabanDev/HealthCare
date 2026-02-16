package com.dev.healthcare.repository;

import com.dev.healthcare.entity.HealthPolicy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HpRepository extends JpaRepository<HealthPolicy,Long> {

    boolean existsByPolicyNumber(String policyNumber);
    Optional<HealthPolicy> findByPolicyNumber(String policyNumber);
}