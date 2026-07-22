package com.resumeshastra.service.impl;

import java.util.List;
import com.resumeshastra.dto.CertificationDTO;
import com.resumeshastra.entity.Certification;
import com.resumeshastra.entity.Resume;
import com.resumeshastra.mapper.CertificationMapper;
import com.resumeshastra.repository.CertificationRepository;
import com.resumeshastra.repository.ResumeRepository;
import com.resumeshastra.response.CertificationResponseDTO;
import com.resumeshastra.service.CertificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CertificationServiceImpl implements CertificationService {

    private final CertificationRepository certificationRepository;
    private final ResumeRepository resumeRepository;
    private final CertificationMapper certificationMapper;

    @Override
    public CertificationResponseDTO saveCertification(Long resumeId, CertificationDTO dto) {

        Resume resume = resumeRepository.findById(resumeId)
                .orElseThrow(() -> new RuntimeException("Resume not found"));

        Certification certification = certificationMapper.dtoToEntity(dto);

        certification.setResume(resume);

        Certification savedCertification = certificationRepository.save(certification);

        return certificationMapper.entityToResponse(savedCertification);
    }
    @Override
    public List<CertificationResponseDTO> getCertifications(Long resumeId) {

    return certificationRepository.findByResumeIdOrderByDisplayOrderAsc(resumeId)
            .stream()
            .map(certificationMapper::entityToResponse)
            .toList();
}
    @Override
public CertificationResponseDTO updateCertification(Long id, CertificationDTO dto) {

    Certification certification = certificationRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Certification not found"));

    certification.setCertificationName(dto.getCertificationName());
    certification.setIssuingOrganization(dto.getIssuingOrganization());
    certification.setIssueDate(dto.getIssueDate());
    certification.setExpiryDate(dto.getExpiryDate());
    certification.setCredentialId(dto.getCredentialId());
    certification.setCredentialUrl(dto.getCredentialUrl());
    certification.setDisplayOrder(dto.getDisplayOrder());

    Certification updatedCertification = certificationRepository.save(certification);

    return certificationMapper.entityToResponse(updatedCertification);
}
    @Override
public void deleteCertification(Long id) {

    Certification certification = certificationRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Certification not found"));

    certificationRepository.delete(certification);
}
}