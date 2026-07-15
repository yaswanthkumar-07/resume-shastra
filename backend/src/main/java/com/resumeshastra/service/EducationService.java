package com.resumeshastra.service;

import com.resumeshastra.dto.EducationDTO;

public interface EducationService {

    Long saveEducation(Long resumeId, EducationDTO dto);

}