package com.dev.healthcare.dto.response;

import com.dev.healthcare.PolicyStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class HPResDto {

    private Long policyId;
    private String policyNumber;
    private String policyType;
    private String policyName;
    private LocalDate policyStartDate;
    private LocalDate policyEndDate;
    private PolicyStatus status;
}
