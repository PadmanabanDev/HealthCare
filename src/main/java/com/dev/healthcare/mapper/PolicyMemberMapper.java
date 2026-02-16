package com.dev.healthcare.mapper;

import com.dev.healthcare.dto.request.PolicyMemberReqDto;
import com.dev.healthcare.dto.response.PolicyMemberResDto;
import com.dev.healthcare.entity.HealthPolicy;
import com.dev.healthcare.entity.PolicyMember;
import org.springframework.stereotype.Component;

@Component
public class PolicyMemberMapper {

    public PolicyMember toEntity(PolicyMemberReqDto dto, HealthPolicy policy){
        PolicyMember member = new PolicyMember();
        member.setFullName(dto.getFullName());
        member.setDob(dto.getDob());
        member.setGender(dto.getGender());
        member.setPolicy(policy);
        return member;
    }

    public PolicyMemberResDto toDto(PolicyMember entity){
        PolicyMemberResDto dto = new PolicyMemberResDto();
        dto.setMemberId(entity.getMemberId());
        dto.setFullName(entity.getFullName());
        dto.setDob(entity.getDob());
        dto.setGender(entity.getGender());
        dto.setPolicyId(entity.getPolicy().getPolicyId());
        return dto;
    }
}
