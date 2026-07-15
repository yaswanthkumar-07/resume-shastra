package com.resumeshastra.service;

import com.resumeshastra.dto.SkillDTO;

public interface SkillService {

    Long saveSkill(Long resumeId, SkillDTO dto);

}