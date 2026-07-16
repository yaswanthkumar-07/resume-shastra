package com.resumeshastra.service;

import com.resumeshastra.dto.CertificationDTO;

public interface CertificationService {

    Long saveCertification(Long resumeId, CertificationDTO dto);

}