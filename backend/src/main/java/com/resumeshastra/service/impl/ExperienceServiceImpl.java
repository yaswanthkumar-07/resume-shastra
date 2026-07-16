package com.resumeshastra.service.impl;

import com.resumeshastra.dto.ExperienceDTO;
import com.resumeshastra.entity.Experience;
import com.resumeshastra.entity.Resume;
import com.resumeshastra.mapper.ExperienceMapper;
import com.resumeshastra.repository.ExperienceRepository;
import com.resumeshastra.repository.ResumeRepository;
import com.resumeshastra.service.ExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExperienceServiceImpl implements ExperienceService {

    private final ExperienceRepository experienceRepository;
    private final ResumeRepository resumeRepository;
    private final ExperienceMapper experienceMapper;

    @Override
    public Long saveExperience(Long resumeId, ExperienceDTO dto) {

        Resume resume = resumeRepository.findById(resumeId)
                .orElseThrow(() -> new RuntimeException("Resume not found"));

        Experience experience = experienceMapper.dtoToEntity(dto);

        experience.setResume(resume);

        Experience savedExperience = experienceRepository.save(experience);

        return savedExperience.getId();
    }
}