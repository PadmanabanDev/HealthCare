package com.dev.healthcare.service;

import com.dev.healthcare.dto.request.MemberDataReqDto;
import com.dev.healthcare.dto.response.MemberDataResDto;

public interface MemberDataService {
    MemberDataResDto create(MemberDataReqDto dto);

    MemberDataResDto getByMemberId(Long memberId);

    MemberDataResDto update(Long memberId, MemberDataReqDto dto);

    void delete(Long memberId);
}
