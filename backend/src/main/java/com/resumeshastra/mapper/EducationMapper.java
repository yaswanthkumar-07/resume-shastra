package com.resumeshastra.mapper;

import com.resumeshastra.dto.EducationDTO;
import com.resumeshastra.entity.Education;
import com.resumeshastra.entity.Resume;
import com.resumeshastra.response.EducationResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class EducationMapper {

    public Education toEntity(EducationDTO dto, Resume resume) {
        return Education.builder()
                .resume(resume)
                .educationLevel(dto.getEducationLevel())
                .customEducationLevel(dto.getCustomEducationLevel())
                .degree(dto.getDegree())
                .customDegree(dto.getCustomDegree())
                .branch(dto.getBranch())
                .major(dto.getMajor())
                .minor(dto.getMinor())
                .specialization(dto.getSpecialization())
                .institution(dto.getInstitution())
                .universityBoard(dto.getUniversityBoard())
                .scoreType(dto.getScoreType())
                .score(dto.getScore())
                .startMonth(dto.getStartMonth())
                .startYear(dto.getStartYear())
                .endMonth(dto.getEndMonth())
                .endYear(dto.getEndYear())
                .currentlyStudying(dto.getCurrentlyStudying())
                .description(dto.getDescription())
                .displayOrder(dto.getDisplayOrder())
                .build();
    }

    public EducationResponseDTO toResponseDTO(Education education) {
        return EducationResponseDTO.builder()
                .id(education.getId())
                .educationLevel(education.getEducationLevel())
                .customEducationLevel(education.getCustomEducationLevel())
                .degree(education.getDegree())
                .customDegree(education.getCustomDegree())
                .branch(education.getBranch())
                .major(education.getMajor())
                .minor(education.getMinor())
                .specialization(education.getSpecialization())
                .institution(education.getInstitution())
                .universityBoard(education.getUniversityBoard())
                .scoreType(education.getScoreType())
                .score(education.getScore())
                .startMonth(education.getStartMonth())
                .startYear(education.getStartYear())
                .endMonth(education.getEndMonth())
                .endYear(education.getEndYear())
                .currentlyStudying(education.getCurrentlyStudying())
                .description(education.getDescription())
                .displayOrder(education.getDisplayOrder())
                .build();
    }

    public void updateEntity(Education entity, EducationDTO dto) {
        entity.setEducationLevel(dto.getEducationLevel());
        entity.setCustomEducationLevel(dto.getCustomEducationLevel());
        entity.setDegree(dto.getDegree());
        entity.setCustomDegree(dto.getCustomDegree());
        entity.setBranch(dto.getBranch());
        entity.setMajor(dto.getMajor());
        entity.setMinor(dto.getMinor());
        entity.setSpecialization(dto.getSpecialization());
        entity.setInstitution(dto.getInstitution());
        entity.setUniversityBoard(dto.getUniversityBoard());
        entity.setScoreType(dto.getScoreType());
        entity.setScore(dto.getScore());
        entity.setStartMonth(dto.getStartMonth());
        entity.setStartYear(dto.getStartYear());
        entity.setEndMonth(dto.getEndMonth());
        entity.setEndYear(dto.getEndYear());
        entity.setCurrentlyStudying(dto.getCurrentlyStudying());
        entity.setDescription(dto.getDescription());
        entity.setDisplayOrder(dto.getDisplayOrder());
    }
}