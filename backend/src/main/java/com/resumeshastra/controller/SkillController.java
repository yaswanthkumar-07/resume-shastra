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
@RequestMapping("/api/skills")
@RequiredArgsConstructor
public class SkillController {

    private final SkillService skillService;

    @PostMapping("/{resumeId}")
    public ResponseEntity<ApiResponse<SkillResponseDTO>> saveSkill(
            @PathVariable Long resumeId,
            @Valid @RequestBody SkillDTO dto) {
            
        SkillResponseDTO response = skillService.saveSkill(resumeId, dto);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.<SkillResponseDTO>builder()
                        .status("SUCCESS")
                        .message("Skill saved successfully")
                        .data(response)
                        .errors(List.of())
                        .build()
        );
    }

    @GetMapping("/{resumeId}")
    public ResponseEntity<ApiResponse<List<SkillResponseDTO>>> getSkills(
            @PathVariable Long resumeId) {
            
        List<SkillResponseDTO> response = skillService.getSkills(resumeId);
        
        return ResponseEntity.ok(
                ApiResponse.<List<SkillResponseDTO>>builder()
                        .status("SUCCESS")
                        .message("Skills fetched successfully")
                        .data(response)
                        .errors(List.of())
                        .build()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<SkillResponseDTO>> updateSkill(
            @PathVariable Long id,
            @Valid @RequestBody SkillDTO dto) {
            
        SkillResponseDTO response = skillService.updateSkill(id, dto);
        
        return ResponseEntity.ok(
                ApiResponse.<SkillResponseDTO>builder()
                        .status("SUCCESS")
                        .message("Skill updated successfully")
                        .data(response)
                        .errors(List.of())
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteSkill(@PathVariable Long id) {
    
        skillService.deleteSkill(id);
        
        return ResponseEntity.ok(
                ApiResponse.<Void>builder()
                        .status("SUCCESS")
                        .message("Skill deleted successfully")
                        .data(null)
                        .errors(List.of())
                        .build()
        );
    }
}