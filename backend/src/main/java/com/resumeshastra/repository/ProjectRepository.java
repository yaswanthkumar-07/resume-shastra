package com.resumeshastra.repository;

import com.resumeshastra.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findByResumeIdOrderByDisplayOrderAsc(Long resumeId);

}