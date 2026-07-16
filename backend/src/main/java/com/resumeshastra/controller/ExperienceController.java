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
@CrossOrigin(origins = "http://localhost:5173")
public class ExperienceController {

    private final ExperienceService experienceService;

    @PostMapping
    public ResponseEntity<ApiResponse<ExperienceResponseDTO>> saveExperience(
            @PathVariable Long resumeId,
            @Valid @RequestBody ExperienceDTO dto) {

        Long experienceId = experienceService.saveExperience(resumeId, dto);

        ExperienceResponseDTO result = ExperienceResponseDTO.builder()
                .experienceId(experienceId)
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
}