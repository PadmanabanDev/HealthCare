package com.dev.healthcare.service;

import com.dev.healthcare.dto.request.PolicyMemberReqDto;
import com.dev.healthcare.dto.response.PolicyMemberResDto;

public interface PolicyMemberService {
    PolicyMemberResDto createMember(PolicyMemberReqDto dto);
    PolicyMemberResDto getMemberById(Long memberId);
    PolicyMemberResDto updateMember(Long memberId, PolicyMemberReqDto dto);
    void deleteMember(Long memberId);
}
