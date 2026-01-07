package com.dev.healthcare.repository;

import com.dev.healthcare.entity.PolicyMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PolicyMemberRepository extends JpaRepository<PolicyMember,Long> {

    List<PolicyMember>findByPolicy_policyId(Long policyId);
}
