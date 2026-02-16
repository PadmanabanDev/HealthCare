package com.dev.healthcare.dto.request;

import com.dev.healthcare.PolicyStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HPUpdateReqDto {
    @NotBlank(message = "Policy number is required")
    private String policyNumber;

    @NotBlank(message = "Policy name is required")
    private String policyName;

    @NotBlank(message = "Policy type is required")
    private String policyType;

    @NotNull(message = "Start date is required")
    private LocalDate startDate;

    @NotNull(message = "End date is required")
    private LocalDate endDate;

    @NotNull(message = "Status is required")
    private PolicyStatus status;
}
