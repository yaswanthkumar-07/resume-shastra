package com.resumeshastra.service.impl;

import com.resumeshastra.dto.ProjectDTO;
import com.resumeshastra.entity.Project;
import com.resumeshastra.entity.Resume;
import com.resumeshastra.mapper.ProjectMapper;
import com.resumeshastra.repository.ProjectRepository;
import com.resumeshastra.repository.ResumeRepository;
import com.resumeshastra.response.ProjectResponseDTO;
import com.resumeshastra.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ResumeRepository resumeRepository;
    private final ProjectMapper projectMapper;

    @Override
    public Long saveProject(Long resumeId, ProjectDTO dto) {

        Resume resume = resumeRepository.findById(resumeId)
                .orElseThrow(() -> new RuntimeException("Resume not found"));

        Project project = projectMapper.dtoToEntity(dto);

        project.setResume(resume);

        Project savedProject = projectRepository.save(project);

        return savedProject.getId();
    }

    @Override
    public List<ProjectResponseDTO> getProjectsByResumeId(Long resumeId) {

        return projectRepository.findByResumeIdOrderByDisplayOrderAsc(resumeId)
                .stream()
                .map(projectMapper::entityToResponse)
                .toList();
    }

    @Override
    public void updateProject(Long projectId, ProjectDTO dto) {

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        project.setProjectName(dto.getProjectName());
        project.setDescription(dto.getDescription());
        project.setTechnologies(dto.getTechnologies());
        project.setGithubUrl(dto.getGithubUrl());
        project.setLiveUrl(dto.getLiveUrl());
        project.setFeatured(dto.getFeatured());
        project.setDisplayOrder(dto.getDisplayOrder());

        projectRepository.save(project);
    }

    @Override
    public void deleteProject(Long projectId) {

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        projectRepository.delete(project);
    }
}