package com.dev.healthcare.controller;

import com.dev.healthcare.dto.request.HPReqDto;
import com.dev.healthcare.dto.response.HPResDto;
import com.dev.healthcare.service.HpService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/policies")
public class HpController {

    private  final HpService hpService;

    public HpController(HpService hpService){
        this.hpService=hpService;
    }

    @PostMapping
    public ResponseEntity<HPResDto> create(
            @Valid @RequestBody HPReqDto dto){
        HPResDto response = hpService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }
}
