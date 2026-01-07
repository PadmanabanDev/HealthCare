package com.dev.healthcare.service;

import com.dev.healthcare.dto.request.HPReqDto;
import com.dev.healthcare.dto.request.HPUpdateReqDto;
import com.dev.healthcare.dto.response.HPResDto;

public interface HpService {

    HPResDto create(HPReqDto dto);
    HPResDto getById(Long policyId);
    HPResDto getByPolicyNumber(String policyNumber);
    HPResDto updatePolicy(Long policyId, HPUpdateReqDto dto);
}
