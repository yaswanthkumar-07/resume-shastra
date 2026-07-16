package com.resumeshastra.service;

import com.resumeshastra.dto.ExperienceDTO;

public interface ExperienceService {

    Long saveExperience(Long resumeId, ExperienceDTO dto);

}