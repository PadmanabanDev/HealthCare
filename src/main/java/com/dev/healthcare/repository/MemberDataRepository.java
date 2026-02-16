package com.dev.healthcare.repository;

import com.dev.healthcare.entity.MemberData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberDataRepository extends JpaRepository<MemberData, Long>{



        Optional<MemberData> findByPolicyMember_MemberId(Long memberId);
}
