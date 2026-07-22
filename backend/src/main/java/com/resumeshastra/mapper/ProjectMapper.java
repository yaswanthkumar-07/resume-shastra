package com.resumeshastra.mapper;

import com.resumeshastra.dto.ProjectDTO;
import com.resumeshastra.entity.Project;
import com.resumeshastra.response.ProjectResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {

    public Project dtoToEntity(ProjectDTO dto) {

        return Project.builder()
                .projectName(dto.getProjectName())
                .description(dto.getDescription())
                .technologies(dto.getTechnologies())
                .githubUrl(dto.getGithubUrl())
                .liveUrl(dto.getLiveUrl())
                .featured(dto.getFeatured())
                .displayOrder(dto.getDisplayOrder())
                .build();
    }

    public ProjectDTO entityToDto(Project project) {

        return ProjectDTO.builder()
                .projectName(project.getProjectName())
                .description(project.getDescription())
                .technologies(project.getTechnologies())
                .githubUrl(project.getGithubUrl())
                .liveUrl(project.getLiveUrl())
                .featured(project.getFeatured())
                .displayOrder(project.getDisplayOrder())
                .build();
    }

    public ProjectResponseDTO entityToResponse(Project project) {

        return ProjectResponseDTO.builder()
                .id(project.getId())
                .projectName(project.getProjectName())
                .description(project.getDescription())
                .technologies(project.getTechnologies())
                .githubUrl(project.getGithubUrl())
                .liveUrl(project.getLiveUrl())
                .featured(project.getFeatured())
                .displayOrder(project.getDisplayOrder())
                .build();
    }
}