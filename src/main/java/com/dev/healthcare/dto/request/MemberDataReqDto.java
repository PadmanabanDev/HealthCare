package com.dev.healthcare.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MemberDataReqDto {

    @NotBlank(message = "Adhar number is required")
    private String adharNo;

    @NotBlank(message = "Phone number is required")
    private String phoneNo;


    private String state;
    private String district;

    @NotNull(message = "Member id is required")
    private Long memberId;
}
