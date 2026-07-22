package com.resumeshastra.service.impl;

import com.resumeshastra.dto.ExperienceDTO;
import com.resumeshastra.entity.Experience;
import com.resumeshastra.entity.Resume;
import com.resumeshastra.mapper.ExperienceMapper;
import com.resumeshastra.repository.ExperienceRepository;
import com.resumeshastra.repository.ResumeRepository;
import com.resumeshastra.response.ExperienceResponseDTO;
import com.resumeshastra.service.ExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<ExperienceResponseDTO> getExperiencesByResumeId(Long resumeId) {

        return experienceRepository.findByResumeIdOrderByDisplayOrderAsc(resumeId)
                .stream()
                .map(experienceMapper::entityToResponse)
                .toList();
    }

    @Override
    public void updateExperience(Long experienceId, ExperienceDTO dto) {

        Experience experience = experienceRepository.findById(experienceId)
                .orElseThrow(() -> new RuntimeException("Experience not found"));

        experience.setCompanyName(dto.getCompanyName());
        experience.setJobTitle(dto.getJobTitle());
        experience.setEmploymentType(dto.getEmploymentType());
        experience.setLocation(dto.getLocation());
        experience.setStartDate(dto.getStartDate());
        experience.setEndDate(dto.getEndDate());
        experience.setCurrentlyWorking(dto.getCurrentlyWorking());
        experience.setDescription(dto.getDescription());
        experience.setDisplayOrder(dto.getDisplayOrder());

        experienceRepository.save(experience);
    }

    @Override
    public void deleteExperience(Long experienceId) {

        Experience experience = experienceRepository.findById(experienceId)
                .orElseThrow(() -> new RuntimeException("Experience not found"));

        experienceRepository.delete(experience);
    }
}