package com.dev.healthcare.controller;

import com.dev.healthcare.dto.request.HPReqDto;
import com.dev.healthcare.dto.request.HPUpdateReqDto;
import com.dev.healthcare.dto.response.HPResDto;
import com.dev.healthcare.service.HpService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
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

    @GetMapping("policy-id/{policyId}")
    public ResponseEntity<HPResDto> getPolicyById(
            @PathVariable Long policyId
    ){
        HPResDto response = hpService.getById(policyId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/policy-number/{policyNumber}")
    public ResponseEntity<HPResDto> getByPolicyNumber(@PathVariable String policyNumber){
        HPResDto response = hpService.getByPolicyNumber(policyNumber);
        return  ResponseEntity.ok(response);
    }


    @PutMapping("/{policyId}")
    public ResponseEntity<HPResDto> updatePolicy(
            @PathVariable Long policyId,
            @Valid @RequestBody HPUpdateReqDto dto
            ){
        HPResDto response = hpService.updatePolicy(policyId,dto);
        return ResponseEntity.ok(response);
    }
}
