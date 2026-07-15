package com.resumeshastra.mapper;

import com.resumeshastra.dto.EducationDTO;
import com.resumeshastra.entity.Education;
import org.springframework.stereotype.Component;

@Component
public class EducationMapper {

    public Education dtoToEntity(EducationDTO dto) {

        return Education.builder()
                .degree(dto.getDegree())
                .institution(dto.getInstitution())
                .fieldOfStudy(dto.getFieldOfStudy())
                .cgpa(dto.getCgpa())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .currentlyStudying(dto.getCurrentlyStudying())
                .description(dto.getDescription())
                .displayOrder(dto.getDisplayOrder())
                .build();
    }

    public EducationDTO entityToDto(Education education) {

        return EducationDTO.builder()
                .degree(education.getDegree())
                .institution(education.getInstitution())
                .fieldOfStudy(education.getFieldOfStudy())
                .cgpa(education.getCgpa())
                .startDate(education.getStartDate())
                .endDate(education.getEndDate())
                .currentlyStudying(education.getCurrentlyStudying())
                .description(education.getDescription())
                .displayOrder(education.getDisplayOrder())
                .build();
    }
}