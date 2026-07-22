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
public class EducationController {

    private final EducationService educationService;

    @PostMapping
    public ResponseEntity<ApiResponse<EducationResponseDTO>> saveEducation(
            @PathVariable Long resumeId,
            @Valid @RequestBody EducationDTO dto) {

        // Changed this to capture the full DTO directly from the service
        EducationResponseDTO result = educationService.saveEducation(resumeId, dto);

        ApiResponse<EducationResponseDTO> response =
                ApiResponse.<EducationResponseDTO>builder()
                        .status("SUCCESS")
                        .message("Education saved successfully")
                        .data(result)
                        .errors(List.of())
                        .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<EducationResponseDTO>>> getEducations(
            @PathVariable Long resumeId) {

        List<EducationResponseDTO> educations =
                educationService.getEducationsByResumeId(resumeId);

        ApiResponse<List<EducationResponseDTO>> response =
                ApiResponse.<List<EducationResponseDTO>>builder()
                        .status("SUCCESS")
                        .message("Educations fetched successfully")
                        .data(educations)
                        .errors(List.of())
                        .build();

        return ResponseEntity.ok(response);
    }

    // 1. ADDED: Get Single Education API
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<EducationResponseDTO>> getEducation(
            @PathVariable Long resumeId,
            @PathVariable Long id) {

        EducationResponseDTO education = educationService.getEducation(id);

        ApiResponse<EducationResponseDTO> response =
                ApiResponse.<EducationResponseDTO>builder()
                        .status("SUCCESS")
                        .message("Education fetched successfully")
                        .data(education)
                        .errors(List.of())
                        .build();

        return ResponseEntity.ok(response);
    }

    // 2. FIXED: Added resumeId PathVariable
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> updateEducation(
            @PathVariable Long resumeId,
            @PathVariable Long id,
            @Valid @RequestBody EducationDTO dto) {

        educationService.updateEducation(id, dto);

        ApiResponse<Void> response =
                ApiResponse.<Void>builder()
                        .status("SUCCESS")
                        .message("Education updated successfully")
                        .data(null)
                        .errors(List.of())
                        .build();

        return ResponseEntity.ok(response);
    }

    // 2. FIXED: Added resumeId PathVariable
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteEducation(
            @PathVariable Long resumeId,
            @PathVariable Long id) {

        educationService.deleteEducation(id);

        ApiResponse<Void> response =
                ApiResponse.<Void>builder()
                        .status("SUCCESS")
                        .message("Education deleted successfully")
                        .data(null)
                        .errors(List.of())
                        .build();

        return ResponseEntity.ok(response);
    }

    // 3. ADDED: PatchMapping for display order swapping
    @PatchMapping("/{id}/display-order")
    public ResponseEntity<ApiResponse<Void>> updateDisplayOrder(
            @PathVariable Long resumeId,
            @PathVariable Long id,
            @RequestParam Integer displayOrder) {

        educationService.updateDisplayOrder(id, displayOrder);

        ApiResponse<Void> response =
                ApiResponse.<Void>builder()
                        .status("SUCCESS")
                        .message("Education order updated successfully")
                        .data(null)
                        .errors(List.of())
                        .build();

        return ResponseEntity.ok(response);
    }
}