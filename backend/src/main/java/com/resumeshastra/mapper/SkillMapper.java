package com.resumeshastra.mapper;

import com.resumeshastra.dto.SkillDTO;
import com.resumeshastra.entity.Skill;
import com.resumeshastra.response.SkillResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class SkillMapper {

    public Skill dtoToEntity(SkillDTO dto) {

    return Skill.builder()
            .id(dto.getId())
            .name(dto.getName())
            .category(dto.getCategory())
            .displayOrder(dto.getDisplayOrder())
            .build();
}

    public SkillResponseDTO entityToResponse(Skill skill) {

    return SkillResponseDTO.builder()
            .id(skill.getId())
            .resumeId(skill.getResume() != null ? skill.getResume().getId() : null)
            .name(skill.getName())
            .category(skill.getCategory())
            .displayOrder(skill.getDisplayOrder())
            .build();
}
}