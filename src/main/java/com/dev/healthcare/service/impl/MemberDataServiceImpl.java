package com.dev.healthcare.service.impl;

import com.dev.healthcare.dto.request.MemberDataReqDto;
import com.dev.healthcare.dto.response.MemberDataResDto;
import com.dev.healthcare.entity.MemberData;
import com.dev.healthcare.entity.PolicyMember;
import com.dev.healthcare.exception.ResourceNotFoundException;
import com.dev.healthcare.mapper.MemberDataMapper;
import com.dev.healthcare.repository.MemberDataRepository;
import com.dev.healthcare.repository.PolicyMemberRepository;
import com.dev.healthcare.service.MemberDataService;
import org.springframework.stereotype.Service;

@Service
public class MemberDataServiceImpl implements MemberDataService {
    private final MemberDataRepository repository;
    private final PolicyMemberRepository memberRepository;
    private final MemberDataMapper mapper;

    public MemberDataServiceImpl(
            MemberDataRepository repository,
            PolicyMemberRepository memberRepository,
            MemberDataMapper mapper
    ) {
        this.repository = repository;
        this.memberRepository = memberRepository;
        this.mapper = mapper;
    }

    @Override
    public MemberDataResDto create(MemberDataReqDto dto) {

        PolicyMember member = memberRepository.findById(dto.getMemberId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Policy member not found"));

        // Prevent duplicate MemberData
        repository.findByPolicyMember_MemberId(dto.getMemberId())
                .ifPresent(md -> {
                    throw new BusinessException("Member data already exists");
                });

        MemberData data = mapper.toEntity(dto, member);
        return mapper.toDto(repository.save(data));
    }

    @Override
    public MemberDataResDto getByMemberId(Long memberId) {

        MemberData data = repository.findByPolicyMember_MemberId(memberId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Member data not found"));

        return mapper.toDto(data);
    }

    @Override
    public MemberDataResDto update(Long memberId, MemberDataReqDto dto) {

        MemberData data = repository.findByPolicyMember_MemberId(memberId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Member data not found"));

        data.setPhoneNo(dto.getPhoneNo());
        data.setState(dto.getState());
        data.setDistrict(dto.getDistrict());

        return mapper.toDto(data);
    }


    @Override
    public void delete(Long memberId) {

        MemberData data = repository.findByPolicyMember_MemberId(memberId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Member data not found"));

        repository.delete(data);
    }
}
