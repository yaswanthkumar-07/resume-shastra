package com.resumeshastra.service;

import com.resumeshastra.dto.AchievementDTO;
import com.resumeshastra.response.AchievementResponseDTO;

import java.util.List;

public interface AchievementService {

    AchievementResponseDTO saveAchievement(Long resumeId, AchievementDTO dto);

    List<AchievementResponseDTO> getAchievements(Long resumeId);

    AchievementResponseDTO updateAchievement(Long id, AchievementDTO dto);

    void deleteAchievement(Long id);

}