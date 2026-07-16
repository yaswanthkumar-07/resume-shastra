package com.resumeshastra.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CertificationDTO {

    @NotBlank(message = "Certification name is required")
    private String certificationName;

    @NotBlank(message = "Issuing organization is required")
    private String issuingOrganization;

    @NotBlank(message = "Issue date is required")
    private String issueDate;

    private String expiryDate;

    private String credentialId;

    private String credentialUrl;

    private Integer displayOrder;
}