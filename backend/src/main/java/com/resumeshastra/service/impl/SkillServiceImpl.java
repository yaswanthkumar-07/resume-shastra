package com.resumeshastra.service.impl;

import com.resumeshastra.dto.SkillDTO;
import com.resumeshastra.entity.Resume;
import com.resumeshastra.entity.Skill;
import com.resumeshastra.mapper.SkillMapper;
import com.resumeshastra.repository.ResumeRepository;
import com.resumeshastra.repository.SkillRepository;
import com.resumeshastra.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {

    private final SkillRepository skillRepository;
    private final ResumeRepository resumeRepository;
    private final SkillMapper skillMapper;

    @Override
    public Long saveSkill(Long resumeId, SkillDTO dto) {

        Resume resume = resumeRepository.findById(resumeId)
                .orElseThrow(() -> new RuntimeException("Resume not found"));

        Skill skill = skillMapper.dtoToEntity(dto);

        skill.setResume(resume);

        Skill savedSkill = skillRepository.save(skill);

        return savedSkill.getId();
    }
}