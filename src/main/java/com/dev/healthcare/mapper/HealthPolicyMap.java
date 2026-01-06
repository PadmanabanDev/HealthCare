package com.dev.healthcare.mapper;

import com.dev.healthcare.dto.request.HPReqDto;
import com.dev.healthcare.dto.response.HPResDto;
import com.dev.healthcare.entity.HealthPolicy;
import org.springframework.stereotype.Component;

@Component
public class HealthPolicyMap {

    public HealthPolicy toEntity(HPReqDto dto){
        HealthPolicy healthPolicy = new HealthPolicy();
        healthPolicy.setPolicyNumber(dto.getPolicyNumber());
        healthPolicy.setPolicyType(dto.getPolicyType());
        healthPolicy.setPolicyName(dto.getPolicyName());
        healthPolicy.setPolicyStartDate(dto.getPolicyStartDate());
        healthPolicy.setPolicyEndDate(dto.getPolicyEndDate());
        healthPolicy.setStatus(dto.getStatus());
        return healthPolicy;
    }

    public HPResDto toDto(HealthPolicy entity){
        if (entity == null) return null;
        HPResDto dto = new HPResDto();
        dto.setPolicyId(entity.getPolicyId());
        dto.setPolicyNumber(entity.getPolicyNumber());
        dto.setPolicyType(entity.getPolicyType());
        dto.setPolicyName(entity.getPolicyName());
        dto.setPolicyStartDate(entity.getPolicyStartDate());
        dto.setPolicyEndDate(entity.getPolicyEndDate());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public void updateEntity(HealthPolicy entity, HPReqDto dto){
        entity.setPolicyType(dto.getPolicyType());
        entity.setPolicyName(dto.getPolicyName());
        entity.setPolicyStartDate(dto.getPolicyStartDate());
        entity.setPolicyEndDate(dto.getPolicyEndDate());
        entity.setStatus(dto.getStatus());
    }
}
