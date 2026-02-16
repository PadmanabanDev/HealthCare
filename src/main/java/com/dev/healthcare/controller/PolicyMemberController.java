package com.dev.healthcare.controller;

import com.dev.healthcare.dto.request.PolicyMemberReqDto;
import com.dev.healthcare.dto.response.PolicyMemberResDto;
import com.dev.healthcare.service.PolicyMemberService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/memberspol")
public class PolicyMemberController {

    private final PolicyMemberService memberService;

    public PolicyMemberController(PolicyMemberService memberService){
        this.memberService= memberService;
    }

    @PostMapping
    public ResponseEntity<PolicyMemberResDto> create(
            @Valid @RequestBody PolicyMemberReqDto dto
            ){
        PolicyMemberResDto response = memberService.createMember(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PolicyMemberResDto> getById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(memberService.getMemberById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PolicyMemberResDto> update(
            @PathVariable Long id,
            @RequestBody @Valid PolicyMemberReqDto dto
    ) {
        return ResponseEntity.ok(memberService.updateMember(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        memberService.deleteMember(id);
        return ResponseEntity.noContent().build();
    }
}
