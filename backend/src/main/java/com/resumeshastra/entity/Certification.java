package com.resumeshastra.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "certifications")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Certification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String certificationName;

    private String issuingOrganization;

    private String issueDate;

    private String expiryDate;

    private String credentialId;

    private String credentialUrl;

    private Integer displayOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id", nullable = false)
    private Resume resume;
}