package com.resumeshastra.mapper;

import com.resumeshastra.dto.ExperienceDTO;
import com.resumeshastra.entity.Experience;
import org.springframework.stereotype.Component;

@Component
public class ExperienceMapper {

    public Experience dtoToEntity(ExperienceDTO dto) {

        return Experience.builder()
                .companyName(dto.getCompanyName())
                .jobTitle(dto.getJobTitle())
                .employmentType(dto.getEmploymentType())
                .location(dto.getLocation())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .currentlyWorking(dto.getCurrentlyWorking())
                .description(dto.getDescription())
                .displayOrder(dto.getDisplayOrder())
                .build();
    }

    public ExperienceDTO entityToDto(Experience experience) {

        return ExperienceDTO.builder()
                .companyName(experience.getCompanyName())
                .jobTitle(experience.getJobTitle())
                .employmentType(experience.getEmploymentType())
                .location(experience.getLocation())
                .startDate(experience.getStartDate())
                .endDate(experience.getEndDate())
                .currentlyWorking(experience.getCurrentlyWorking())
                .description(experience.getDescription())
                .displayOrder(experience.getDisplayOrder())
                .build();
    }
}