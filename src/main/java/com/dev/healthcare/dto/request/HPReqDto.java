package com.dev.healthcare.dto.request;

import com.dev.healthcare.PolicyStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class HPReqDto {


    @NotBlank(message = "Policy number is required")
    private String policyNumber;

    @NotBlank(message = "policy type is required")
    private String policyType;

    @NotBlank(message = "Policy name is required")
    private String policyName;

    @NotNull(message = "Policy start date is required")
    private LocalDate policyStartDate;

    @NotNull(message = "Policy end date is required")
    private LocalDate policyEndDate;

    @NotNull(message = "Policy status is required")
    private PolicyStatus status;
}
