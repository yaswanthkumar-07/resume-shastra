package com.resumeshastra.controller;

import com.resumeshastra.dto.ExperienceDTO;
import com.resumeshastra.response.ApiResponse;
import com.resumeshastra.response.ExperienceResponseDTO;
import com.resumeshastra.service.ExperienceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resumes/{resumeId}/experience")
@RequiredArgsConstructor
public class ExperienceController {

    private final ExperienceService experienceService;

    @PostMapping
    public ResponseEntity<ApiResponse<ExperienceResponseDTO>> saveExperience(
            @PathVariable Long resumeId,
            @Valid @RequestBody ExperienceDTO dto) {

        Long experienceId = experienceService.saveExperience(resumeId, dto);

        ExperienceResponseDTO result = ExperienceResponseDTO.builder()
                .id(experienceId)
                .build();

        ApiResponse<ExperienceResponseDTO> response =
                ApiResponse.<ExperienceResponseDTO>builder()
                        .status("SUCCESS")
                        .message("Experience saved successfully")
                        .data(result)
                        .errors(List.of())
                        .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ExperienceResponseDTO>>> getExperiences(
            @PathVariable Long resumeId) {

        List<ExperienceResponseDTO> experiences =
                experienceService.getExperiencesByResumeId(resumeId);

        ApiResponse<List<ExperienceResponseDTO>> response =
                ApiResponse.<List<ExperienceResponseDTO>>builder()
                        .status("SUCCESS")
                        .message("Experiences fetched successfully")
                        .data(experiences)
                        .errors(List.of())
                        .build();

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> updateExperience(
            @PathVariable Long id,
            @Valid @RequestBody ExperienceDTO dto) {

        experienceService.updateExperience(id, dto);

        ApiResponse<Void> response =
                ApiResponse.<Void>builder()
                        .status("SUCCESS")
                        .message("Experience updated successfully")
                        .data(null)
                        .errors(List.of())
                        .build();

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteExperience(
            @PathVariable Long id) {

        experienceService.deleteExperience(id);

        ApiResponse<Void> response =
                ApiResponse.<Void>builder()
                        .status("SUCCESS")
                        .message("Experience deleted successfully")
                        .data(null)
                        .errors(List.of())
                        .build();

        return ResponseEntity.ok(response);
    }
}