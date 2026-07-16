package com.resumeshastra.service.impl;

import com.resumeshastra.dto.ProjectDTO;
import com.resumeshastra.entity.Project;
import com.resumeshastra.entity.Resume;
import com.resumeshastra.mapper.ProjectMapper;
import com.resumeshastra.repository.ProjectRepository;
import com.resumeshastra.repository.ResumeRepository;
import com.resumeshastra.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}