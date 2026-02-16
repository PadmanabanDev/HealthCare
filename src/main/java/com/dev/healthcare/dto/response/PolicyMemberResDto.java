package com.dev.healthcare.dto.response;

import com.dev.healthcare.Gender;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PolicyMemberResDto {

    private Long memberId;
    private String fullName;
    private LocalDate dob;
    private Gender gender;
    private Long policyId;
}
