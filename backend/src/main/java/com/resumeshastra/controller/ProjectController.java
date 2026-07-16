package com.resumeshastra.controller;

import com.resumeshastra.dto.ProjectDTO;
import com.resumeshastra.response.ApiResponse;
import com.resumeshastra.response.ProjectResponseDTO;
import com.resumeshastra.service.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resumes/{resumeId}/projects")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<ApiResponse<ProjectResponseDTO>> saveProject(
            @PathVariable Long resumeId,
            @Valid @RequestBody ProjectDTO dto) {

        Long projectId = projectService.saveProject(resumeId, dto);

        ProjectResponseDTO result = ProjectResponseDTO.builder()
                .projectId(projectId)
                .build();

        ApiResponse<ProjectResponseDTO> response =
                ApiResponse.<ProjectResponseDTO>builder()
                        .status("SUCCESS")
                        .message("Project saved successfully")
                        .data(result)
                        .errors(List.of())
                        .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}