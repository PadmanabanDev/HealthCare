package com.dev.healthcare.service;

import com.dev.healthcare.dto.request.HPReqDto;
import com.dev.healthcare.dto.response.HPResDto;

public interface HpService {

    HPResDto create(HPReqDto dto);
    HPResDto getById(Long policyId);
}
