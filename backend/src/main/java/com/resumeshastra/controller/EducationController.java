package com.resumeshastra.controller;

import com.resumeshastra.dto.EducationDTO;
import com.resumeshastra.response.ApiResponse;
import com.resumeshastra.response.EducationResponseDTO;
import com.resumeshastra.service.EducationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resumes/{resumeId}/education")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class EducationController {

    private final EducationService educationService;

    @PostMapping
    public ResponseEntity<ApiResponse<EducationResponseDTO>> saveEducation(
            @PathVariable Long resumeId,
            @Valid @RequestBody EducationDTO dto) {

        Long educationId = educationService.saveEducation(resumeId, dto);

        EducationResponseDTO result = EducationResponseDTO.builder()
                .educationId(educationId)
                .build();

        ApiResponse<EducationResponseDTO> response =
                ApiResponse.<EducationResponseDTO>builder()
                        .status("SUCCESS")
                        .message("Education saved successfully")
                        .data(result)
                        .errors(List.of())
                        .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}