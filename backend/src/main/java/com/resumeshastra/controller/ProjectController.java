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
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<ApiResponse<ProjectResponseDTO>> saveProject(
            @PathVariable Long resumeId,
            @Valid @RequestBody ProjectDTO dto) {

        Long projectId = projectService.saveProject(resumeId, dto);

        ProjectResponseDTO result = ProjectResponseDTO.builder()
                .id(projectId)
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

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProjectResponseDTO>>> getProjects(
            @PathVariable Long resumeId) {

        List<ProjectResponseDTO> projects =
                projectService.getProjectsByResumeId(resumeId);

        ApiResponse<List<ProjectResponseDTO>> response =
                ApiResponse.<List<ProjectResponseDTO>>builder()
                        .status("SUCCESS")
                        .message("Projects fetched successfully")
                        .data(projects)
                        .errors(List.of())
                        .build();

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> updateProject(
            @PathVariable Long id,
            @Valid @RequestBody ProjectDTO dto) {

        projectService.updateProject(id, dto);

        ApiResponse<Void> response =
                ApiResponse.<Void>builder()
                        .status("SUCCESS")
                        .message("Project updated successfully")
                        .data(null)
                        .errors(List.of())
                        .build();

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteProject(
            @PathVariable Long id) {

        projectService.deleteProject(id);

        ApiResponse<Void> response =
                ApiResponse.<Void>builder()
                        .status("SUCCESS")
                        .message("Project deleted successfully")
                        .data(null)
                        .errors(List.of())
                        .build();

        return ResponseEntity.ok(response);
    }
}