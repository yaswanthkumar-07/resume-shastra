package com.resumeshastra.service.impl;

import com.resumeshastra.dto.EducationDTO;
import com.resumeshastra.entity.Education;
import com.resumeshastra.entity.Resume;
import com.resumeshastra.mapper.EducationMapper;
import com.resumeshastra.repository.EducationRepository;
import com.resumeshastra.repository.ResumeRepository;
import com.resumeshastra.service.EducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EducationServiceImpl implements EducationService {

    private final EducationRepository educationRepository;
    private final ResumeRepository resumeRepository;
    private final EducationMapper educationMapper;

    @Override
public Long saveEducation(Long resumeId, EducationDTO dto) {

    Resume resume = resumeRepository.findById(resumeId)
            .orElseThrow(() -> new RuntimeException("Resume not found"));

    Education education = educationMapper.dtoToEntity(dto);

    education.setResume(resume);

    Education savedEducation = educationRepository.save(education);

    return savedEducation.getId();
}
}