package com.resumeshastra.mapper;

import com.resumeshastra.dto.SkillDTO;
import com.resumeshastra.entity.Skill;
import org.springframework.stereotype.Component;

@Component
public class SkillMapper {

    public Skill dtoToEntity(SkillDTO dto) {

        return Skill.builder()
                .skillName(dto.getSkillName())
                .category(dto.getCategory())
                .proficiency(dto.getProficiency())
                .displayOrder(dto.getDisplayOrder())
                .build();
    }

    public SkillDTO entityToDto(Skill skill) {

        return SkillDTO.builder()
                .skillName(skill.getSkillName())
                .category(skill.getCategory())
                .proficiency(skill.getProficiency())
                .displayOrder(skill.getDisplayOrder())
                .build();
    }
}