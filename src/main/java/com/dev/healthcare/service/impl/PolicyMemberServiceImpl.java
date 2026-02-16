package com.dev.healthcare.service.impl;

import com.dev.healthcare.dto.request.PolicyMemberReqDto;
import com.dev.healthcare.dto.response.PolicyMemberResDto;
import com.dev.healthcare.entity.HealthPolicy;
import com.dev.healthcare.entity.PolicyMember;
import com.dev.healthcare.exception.ResourceNotFoundException;
import com.dev.healthcare.mapper.PolicyMemberMapper;
import com.dev.healthcare.repository.HpRepository;
import com.dev.healthcare.repository.PolicyMemberRepository;
import com.dev.healthcare.service.PolicyMemberService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;


@Service
public class PolicyMemberServiceImpl implements PolicyMemberService {

    private final PolicyMemberRepository memberRepository;
    private  final PolicyMemberMapper mapper;
    private final HpRepository hpRepository;

    public PolicyMemberServiceImpl(
            PolicyMemberRepository memberRepository,
            PolicyMemberMapper mapper,
            HpRepository hpRepository){
        this.memberRepository=memberRepository;
        this.hpRepository=hpRepository;
        this.mapper=mapper;
    }

    @Transactional
    @Override
    public PolicyMemberResDto createMember(PolicyMemberReqDto dto){
        HealthPolicy policy = hpRepository.findById(dto.getPolicyId())
                .orElseThrow(()->
                        new ResourceNotFoundException("policy not found"));

        PolicyMember member = mapper.toEntity(dto,policy);
        var savedMember = memberRepository.save(member);
        return mapper.toDto(savedMember);

    }

    @Override
    public PolicyMemberResDto getMemberById(Long memberId){
        PolicyMember member =memberRepository.findById(memberId)
                .orElseThrow(() ->
                new ResourceNotFoundException("Member not found"));

        return mapper.toDto(member);
    }

    @Override
    public PolicyMemberResDto updateMember(Long memberId, PolicyMemberReqDto dto){
        PolicyMember member = memberRepository.findById(memberId)
                .orElseThrow(()->
                        new ResourceNotFoundException("Member not found exception"));

        member.setFullName(dto.getFullName());
        member.setDob(dto.getDob());
        member.setGender(dto.getGender());
        return mapper.toDto(member);
    }

    @Override
    public void deleteMember(Long memberId) {
        PolicyMember member = memberRepository.findById(memberId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Member not found"));

        memberRepository.delete(member);
    }
}
