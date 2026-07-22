package com.resumeshastra.mapper;

import com.resumeshastra.entity.Achievement;
import com.resumeshastra.response.AchievementResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class AchievementMapper {

    public AchievementResponseDTO entityToResponse(Achievement achievement) {

        return AchievementResponseDTO.builder()
                .id(achievement.getId())
                .resumeId(achievement.getResume().getId())
                .title(achievement.getTitle())
                .organization(achievement.getOrganization())
                .achievementDate(achievement.getAchievementDate())
                .description(achievement.getDescription())
                .displayOrder(achievement.getDisplayOrder())
                .build();
    }

}