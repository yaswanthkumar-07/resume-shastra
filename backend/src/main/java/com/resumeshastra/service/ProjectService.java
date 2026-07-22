package com.resumeshastra.service;

import com.resumeshastra.dto.ProjectDTO;
import com.resumeshastra.response.ProjectResponseDTO;

import java.util.List;

public interface ProjectService {

    Long saveProject(Long resumeId, ProjectDTO dto);

    List<ProjectResponseDTO> getProjectsByResumeId(Long resumeId);

    void updateProject(Long projectId, ProjectDTO dto);

    void deleteProject(Long projectId);
}