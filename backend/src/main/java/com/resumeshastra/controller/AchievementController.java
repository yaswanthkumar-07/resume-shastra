package com.resumeshastra.controller;

import com.resumeshastra.dto.AchievementDTO;
import com.resumeshastra.response.AchievementResponseDTO;
import com.resumeshastra.response.ApiResponse;
import com.resumeshastra.service.AchievementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resumes/{resumeId}/achievements")
@RequiredArgsConstructor
public class AchievementController {

    private final AchievementService achievementService;

    @PostMapping
    public ResponseEntity<ApiResponse<AchievementResponseDTO>> createAchievement(
            @PathVariable Long resumeId,
            @Valid @RequestBody AchievementDTO dto) {

        AchievementResponseDTO result =
                achievementService.saveAchievement(resumeId, dto);

        ApiResponse<AchievementResponseDTO> response =
                ApiResponse.<AchievementResponseDTO>builder()
                        .status("SUCCESS")
                        .message("Achievement saved successfully")
                        .data(result)
                        .errors(List.of())
                        .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<AchievementResponseDTO>>> getAchievements(
            @PathVariable Long resumeId) {

        List<AchievementResponseDTO> result =
                achievementService.getAchievements(resumeId);

        ApiResponse<List<AchievementResponseDTO>> response =
                ApiResponse.<List<AchievementResponseDTO>>builder()
                        .status("SUCCESS")
                        .message("Achievements fetched successfully")
                        .data(result)
                        .errors(List.of())
                        .build();

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<AchievementResponseDTO>> updateAchievement(
            @PathVariable Long id,
            @Valid @RequestBody AchievementDTO dto) {

        AchievementResponseDTO result =
                achievementService.updateAchievement(id, dto);

        ApiResponse<AchievementResponseDTO> response =
                ApiResponse.<AchievementResponseDTO>builder()
                        .status("SUCCESS")
                        .message("Achievement updated successfully")
                        .data(result)
                        .errors(List.of())
                        .build();

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteAchievement(
            @PathVariable Long id) {

        achievementService.deleteAchievement(id);

        ApiResponse<Void> response =
                ApiResponse.<Void>builder()
                        .status("SUCCESS")
                        .message("Achievement deleted successfully")
                        .data(null)
                        .errors(List.of())
                        .build();

        return ResponseEntity.ok(response);
    }
}