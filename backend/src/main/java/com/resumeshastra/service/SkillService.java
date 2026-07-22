package com.resumeshastra.service;

import com.resumeshastra.dto.SkillDTO;
import com.resumeshastra.response.SkillResponseDTO;
import java.util.List;

public interface SkillService {
    SkillResponseDTO saveSkill(Long resumeId, SkillDTO dto);
    List<SkillResponseDTO> getSkills(Long resumeId);
    SkillResponseDTO updateSkill(Long id, SkillDTO dto);
    void deleteSkill(Long id);
}