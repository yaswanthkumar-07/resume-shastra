package com.resumeshastra.service;

import com.resumeshastra.dto.ProjectDTO;

public interface ProjectService {

    Long saveProject(Long resumeId, ProjectDTO dto);

}