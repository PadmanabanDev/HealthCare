package com.dev.healthcare.service.impl;


import com.dev.healthcare.dto.request.HPReqDto;
import com.dev.healthcare.dto.response.HPResDto;
import com.dev.healthcare.entity.HealthPolicy;
import com.dev.healthcare.mapper.HealthPolicyMap;
import com.dev.healthcare.repository.HpRepository;
import com.dev.healthcare.service.HpService;
import org.springframework.stereotype.Service;

@Service
public class HpServiceImpl implements HpService {

    private final HpRepository repository;
    private final HealthPolicyMap mapper;

    public HpServiceImpl(HpRepository repository, HealthPolicyMap mapper){
        this.repository=repository;
        this.mapper=mapper;
    }

    @Override
    public HPResDto create(HPReqDto dto){
        HealthPolicy healthPolicy = mapper.toEntity(dto);
        var savedPolicy=repository.save(healthPolicy);
        return mapper.toDto(savedPolicy);
    }

}
