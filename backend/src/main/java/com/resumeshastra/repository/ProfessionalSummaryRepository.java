package com.resumeshastra.repository;

import com.resumeshastra.entity.ProfessionalSummary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfessionalSummaryRepository extends JpaRepository<ProfessionalSummary, Long> {

    Optional<ProfessionalSummary> findByResumeId(Long resumeId);

    boolean existsByResumeId(Long resumeId);

    void deleteByResumeId(Long resumeId);
}