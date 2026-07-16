package com.resumeshastra.service.impl;

import com.resumeshastra.dto.CertificationDTO;
import com.resumeshastra.entity.Certification;
import com.resumeshastra.entity.Resume;
import com.resumeshastra.mapper.CertificationMapper;
import com.resumeshastra.repository.CertificationRepository;
import com.resumeshastra.repository.ResumeRepository;
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
    public Long saveCertification(Long resumeId, CertificationDTO dto) {

        Resume resume = resumeRepository.findById(resumeId)
                .orElseThrow(() -> new RuntimeException("Resume not found"));

        Certification certification = certificationMapper.dtoToEntity(dto);

        certification.setResume(resume);

        Certification savedCertification = certificationRepository.save(certification);

        return savedCertification.getId();
    }
}