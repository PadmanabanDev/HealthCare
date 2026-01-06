package com.dev.healthcare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="member_data")
public class MemberData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "adhaar_no",unique = true,nullable = false)
    private  String adharNo;

    @Column(name = "phone_no",nullable = false)
    private String phoneNo;

    private String state;

    private String district;

    @OneToOne
    @JoinColumn(name = "member_id", nullable = false)
    private PolicyMember policyMember;
}
