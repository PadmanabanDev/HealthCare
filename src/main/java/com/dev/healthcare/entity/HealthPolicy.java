package com.dev.healthcare.entity;

import com.dev.healthcare.PolicyStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="health_policy",
uniqueConstraints = {
        @UniqueConstraint(columnNames = "policy_number")
}
)
public class HealthPolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long policyId;

    @Column(name="policy_number", nullable = false)
    private String policyNumber;

    @Column(name="policy_type",nullable = false)
    private String policyType;

    @Column(name="policy_name",nullable = false)
    private String policyName;

    @Column(name="policy_start_date",nullable = false)
    private LocalDate policyStartDate;

    @Column(name="policy_end_date",nullable = false)
    private LocalDate policyEndDate;

    @Enumerated(EnumType.STRING)
    @Column(name="status",nullable = false)
    private PolicyStatus status;

    @OneToMany(
            mappedBy = "policy",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PolicyMember> members = new ArrayList<>();
}
