package com.resumeshastra.service.impl;

import com.resumeshastra.dto.AchievementDTO;
import com.resumeshastra.entity.Achievement;
import com.resumeshastra.entity.Resume;
import com.resumeshastra.mapper.AchievementMapper;
import com.resumeshastra.repository.AchievementRepository;
import com.resumeshastra.repository.ResumeRepository;
import com.resumeshastra.response.AchievementResponseDTO;
import com.resumeshastra.service.AchievementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AchievementServiceImpl implements AchievementService {

    private final AchievementRepository achievementRepository;
    private final ResumeRepository resumeRepository;
    private final AchievementMapper achievementMapper;

    @Override
    public AchievementResponseDTO saveAchievement(Long resumeId, AchievementDTO dto) {

        Resume resume = resumeRepository.findById(resumeId)
                 .orElseThrow(() -> new RuntimeException("Resume not found"));

        Achievement achievement = Achievement.builder()
                .title(dto.getTitle())
                .organization(dto.getOrganization())
                .achievementDate(dto.getAchievementDate())
                .description(dto.getDescription())
                .displayOrder(dto.getDisplayOrder())
                .resume(resume)
                .build();

        Achievement savedAchievement = achievementRepository.save(achievement);

        return achievementMapper.entityToResponse(savedAchievement);
    }

    @Override
    public List<AchievementResponseDTO> getAchievements(Long resumeId) {

        return achievementRepository
                .findByResumeIdOrderByDisplayOrderAsc(resumeId)
                .stream()
                .map(achievementMapper::entityToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public AchievementResponseDTO updateAchievement(Long id, AchievementDTO dto) {

        Achievement achievement = achievementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Achievement not found"));

        achievement.setTitle(dto.getTitle());
        achievement.setOrganization(dto.getOrganization());
        achievement.setAchievementDate(dto.getAchievementDate());
        achievement.setDescription(dto.getDescription());
        achievement.setDisplayOrder(dto.getDisplayOrder());

        Achievement updatedAchievement = achievementRepository.save(achievement);

        return achievementMapper.entityToResponse(updatedAchievement);
    }

    @Override
    public void deleteAchievement(Long id) {

        achievementRepository.deleteById(id);

    }
}