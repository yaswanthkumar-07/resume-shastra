package com.resumeshastra.repository;

import com.resumeshastra.entity.SummaryTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SummaryTemplateRepository extends JpaRepository<SummaryTemplate, Long> {

    List<SummaryTemplate> findByCareerCategoryAndIsActiveTrue(String careerCategory);

}