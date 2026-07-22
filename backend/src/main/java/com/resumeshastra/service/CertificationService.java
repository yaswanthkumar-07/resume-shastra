package com.resumeshastra.service;

import com.resumeshastra.dto.CertificationDTO;
import com.resumeshastra.response.CertificationResponseDTO;

import java.util.List;

public interface CertificationService {

    CertificationResponseDTO saveCertification(Long resumeId, CertificationDTO dto);

    List<CertificationResponseDTO> getCertifications(Long resumeId);

    CertificationResponseDTO updateCertification(Long id, CertificationDTO dto);

    void deleteCertification(Long id);
}