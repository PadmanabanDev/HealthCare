package com.dev.healthcare.dto.request;

import com.dev.healthcare.Gender;
import com.dev.healthcare.entity.HealthPolicy;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PolicyMemberReqDto {

    @NotBlank(message = "Member full name is required")
    @Size(min = 3, max = 100,message = "Name must be between 3 and 100 characters")
    private String fullName;

    @NotNull(message = "Date of birth is required")
    @Past(message = "Date of birth must be in the past")
    private LocalDate dob;

    @NotNull(message = "gender is required")
    private Gender gender;


    private Long policyId;

}
