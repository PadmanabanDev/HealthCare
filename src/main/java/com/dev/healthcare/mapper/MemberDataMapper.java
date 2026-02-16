package com.dev.healthcare.mapper;

import com.dev.healthcare.dto.request.MemberDataReqDto;
import com.dev.healthcare.dto.response.MemberDataResDto;
import com.dev.healthcare.entity.MemberData;
import com.dev.healthcare.entity.PolicyMember;

public class MemberDataMapper {

    public MemberData toEntity(MemberDataReqDto dto, PolicyMember policyMember){
        MemberData member = new MemberData();
        member.setAdharNo(dto.getAdharNo());
        member.setPhoneNo(dto.getPhoneNo());
        member.setState(dto.getState());
        member.setDistrict(dto.getDistrict());
        member.setPolicyMember(policyMember);
        return member;

    }

    public MemberDataResDto toDto(MemberData entity){
        MemberDataResDto dto = new MemberDataResDto();
        dto.setId(entity.getId());
        dto.setAdharNo(entity.getAdharNo());
        dto.setPhoneNo(entity.getPhoneNo());
        dto.setState(entity.getDistrict());
        dto.setDistrict(entity.getDistrict());
        dto.setMemberId(entity.getPolicyMember().getMemberId());
        return dto;

    }


}
