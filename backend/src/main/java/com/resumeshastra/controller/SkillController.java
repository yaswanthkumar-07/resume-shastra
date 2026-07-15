package com.resumeshastra.controller;

import com.resumeshastra.dto.SkillDTO;
import com.resumeshastra.response.ApiResponse;
import com.resumeshastra.response.SkillResponseDTO;
import com.resumeshastra.service.SkillService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resumes/{resumeId}/skills")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class SkillController {

    private final SkillService skillService;

    @PostMapping
    public ResponseEntity<ApiResponse<SkillResponseDTO>> saveSkill(
            @PathVariable Long resumeId,
            @Valid @RequestBody SkillDTO dto) {

        Long skillId = skillService.saveSkill(resumeId, dto);

        SkillResponseDTO result = SkillResponseDTO.builder()
                .skillId(skillId)
                .build();

        ApiResponse<SkillResponseDTO> response =
                ApiResponse.<SkillResponseDTO>builder()
                        .status("SUCCESS")
                        .message("Skill saved successfully")
                        .data(result)
                        .errors(List.of())
                        .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}