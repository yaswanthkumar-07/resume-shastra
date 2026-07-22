package com.resumeshastra.service;

import com.resumeshastra.dto.ExperienceDTO;
import com.resumeshastra.response.ExperienceResponseDTO;

import java.util.List;

public interface ExperienceService {

    Long saveExperience(Long resumeId, ExperienceDTO dto);

    List<ExperienceResponseDTO> getExperiencesByResumeId(Long resumeId);

    void updateExperience(Long experienceId, ExperienceDTO dto);

    void deleteExperience(Long experienceId);
}