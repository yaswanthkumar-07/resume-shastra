package com.resumeshastra.mapper;

import com.resumeshastra.dto.CertificationDTO;
import com.resumeshastra.entity.Certification;
import org.springframework.stereotype.Component;

@Component
public class CertificationMapper {

    public Certification dtoToEntity(CertificationDTO dto) {

        return Certification.builder()
                .certificationName(dto.getCertificationName())
                .issuingOrganization(dto.getIssuingOrganization())
                .issueDate(dto.getIssueDate())
                .expiryDate(dto.getExpiryDate())
                .credentialId(dto.getCredentialId())
                .credentialUrl(dto.getCredentialUrl())
                .displayOrder(dto.getDisplayOrder())
                .build();
    }

    public CertificationDTO entityToDto(Certification certification) {

        return CertificationDTO.builder()
                .certificationName(certification.getCertificationName())
                .issuingOrganization(certification.getIssuingOrganization())
                .issueDate(certification.getIssueDate())
                .expiryDate(certification.getExpiryDate())
                .credentialId(certification.getCredentialId())
                .credentialUrl(certification.getCredentialUrl())
                .displayOrder(certification.getDisplayOrder())
                .build();
    }
}