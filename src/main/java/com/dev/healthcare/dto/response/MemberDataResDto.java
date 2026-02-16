package com.dev.healthcare.dto.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDataResDto {
    private Long id;

    private String adharNo;

    private String phoneNo;

    private String state;

    private String district;

    private Long memberId;
}
