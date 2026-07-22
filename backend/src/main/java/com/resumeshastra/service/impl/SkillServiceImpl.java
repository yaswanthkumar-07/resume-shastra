package com.resumeshastra.service.impl;

import com.resumeshastra.dto.SkillDTO;
import com.resumeshastra.response.SkillResponseDTO;
import com.resumeshastra.entity.Resume;
import com.resumeshastra.entity.Skill;
import com.resumeshastra.mapper.SkillMapper;
import com.resumeshastra.repository.ResumeRepository;
import com.resumeshastra.repository.SkillRepository;
import com.resumeshastra.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {

    private final SkillRepository skillRepository;
    private final ResumeRepository resumeRepository;
    private final SkillMapper skillMapper;

    @Override
    public SkillResponseDTO saveSkill(Long resumeId, SkillDTO dto) {
        Resume resume = resumeRepository.findById(resumeId)
                .orElseThrow(() -> new RuntimeException("Resume not found"));

        Skill skill = skillMapper.dtoToEntity(dto);
        skill.setResume(resume);

        Skill savedSkill = skillRepository.save(skill);
        return skillMapper.entityToResponse(savedSkill);
    }

    @Override
    public List<SkillResponseDTO> getSkills(Long resumeId) {
        return skillRepository.findByResumeIdOrderByDisplayOrderAsc(resumeId)
                .stream()
                .map(skillMapper::entityToResponse)
                .toList();
    }

    @Override
    public SkillResponseDTO updateSkill(Long id, SkillDTO dto) {
        Skill skill = skillRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Skill not found"));

        skill.setName(dto.getName());
        skill.setCategory(dto.getCategory());
        skill.setDisplayOrder(dto.getDisplayOrder());

        Skill updatedSkill = skillRepository.save(skill);
        return skillMapper.entityToResponse(updatedSkill);
    }

    @Override
    public void deleteSkill(Long id) {
        Skill skill = skillRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Skill not found"));

        skillRepository.delete(skill);
    }
}