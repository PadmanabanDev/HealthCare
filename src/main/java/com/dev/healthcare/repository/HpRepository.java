package com.dev.healthcare.repository;

import com.dev.healthcare.entity.HealthPolicy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HpRepository extends JpaRepository<HealthPolicy,Long> {
}
