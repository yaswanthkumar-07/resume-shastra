package com.resumeshastra.service;

import com.resumeshastra.dto.EducationDTO;
import com.resumeshastra.response.EducationResponseDTO;

import java.util.List;

public interface EducationService {

    EducationResponseDTO saveEducation(Long resumeId, EducationDTO dto);
    
    List<EducationResponseDTO> getEducationsByResumeId(Long resumeId);

    // ADDED THIS LINE
    EducationResponseDTO getEducation(Long id);

    void updateEducation(Long educationId, EducationDTO dto);

    void updateDisplayOrder(Long educationId, Integer newDisplayOrder);

    void deleteEducation(Long educationId);
}