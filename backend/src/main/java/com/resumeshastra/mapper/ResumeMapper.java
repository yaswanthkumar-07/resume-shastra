package com.resumeshastra.mapper;

import com.resumeshastra.dto.PersonalDetailsDTO;
import com.resumeshastra.entity.Resume;
import org.springframework.stereotype.Component;

@Component
public class ResumeMapper {

    public Resume dtoToEntity(PersonalDetailsDTO dto) {

        Resume resume = new Resume();

        resume.setFullName(dto.getFullName());
        resume.setProfessionalTitle(dto.getProfessionalTitle());
        resume.setEmail(dto.getEmail());
        resume.setPhoneNumber(dto.getPhoneNumber());
        resume.setLinkedinUrl(dto.getLinkedinUrl());
        resume.setGithubUrl(dto.getGithubUrl());
        resume.setPortfolioUrl(dto.getPortfolioUrl());
        resume.setLocation(dto.getLocation());

        return resume;
    }

    public PersonalDetailsDTO entityToDto(Resume resume) {

        PersonalDetailsDTO dto = new PersonalDetailsDTO();

        dto.setFullName(resume.getFullName());
        dto.setProfessionalTitle(resume.getProfessionalTitle());
        dto.setEmail(resume.getEmail());
        dto.setPhoneNumber(resume.getPhoneNumber());
        dto.setLinkedinUrl(resume.getLinkedinUrl());
        dto.setGithubUrl(resume.getGithubUrl());
        dto.setPortfolioUrl(resume.getPortfolioUrl());
        dto.setLocation(resume.getLocation());

        return dto;
    }
}