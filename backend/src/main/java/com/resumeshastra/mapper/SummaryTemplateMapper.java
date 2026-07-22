package com.resumeshastra.mapper;

import com.resumeshastra.entity.SummaryTemplate;
import com.resumeshastra.response.SummaryTemplateResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class SummaryTemplateMapper {

    public SummaryTemplateResponseDTO toResponseDTO(SummaryTemplate template){

        return SummaryTemplateResponseDTO.builder()
                .id(template.getId())
                .title(template.getTitle())
                .careerCategory(template.getCareerCategory())
                .jobRole(template.getJobRole())
                .experienceLevel(template.getExperienceLevel())
                .templateText(template.getTemplateText())
                .build();

    }

}