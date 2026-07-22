package com.resumeshastra.service.impl;

import com.resumeshastra.dto.EducationDTO;
import com.resumeshastra.entity.Education;
import com.resumeshastra.entity.Resume;
import com.resumeshastra.mapper.EducationMapper;
import com.resumeshastra.repository.EducationRepository;
import com.resumeshastra.repository.ResumeRepository;
import com.resumeshastra.response.EducationResponseDTO;
import com.resumeshastra.service.EducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EducationServiceImpl implements EducationService {

    private final EducationRepository educationRepository;
    private final ResumeRepository resumeRepository;
    private final EducationMapper educationMapper;

    @Override
    @Transactional
    public EducationResponseDTO saveEducation(Long resumeId, EducationDTO dto) {

        Resume resume = resumeRepository.findById(resumeId)
                .orElseThrow(() -> new RuntimeException("Resume not found"));

        // Use the updated mapper method which maps DTO and assigns the resume
        Education education = educationMapper.toEntity(dto, resume);

        Education savedEducation = educationRepository.save(education);

        // Return the full DTO instead of just the ID
        return educationMapper.toResponseDTO(savedEducation);
    }

    @Override
    public List<EducationResponseDTO> getEducationsByResumeId(Long resumeId) {

        return educationRepository.findByResumeIdOrderByDisplayOrderAsc(resumeId)
                .stream()
                // Use the updated mapper method
                .map(educationMapper::toResponseDTO)
                .toList();
    }

    // ✅ ADDED: getEducation method implementation
    @Override
    public EducationResponseDTO getEducation(Long id) {
        Education education = educationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Education not found"));
        return educationMapper.toResponseDTO(education);
    }

    @Override
    @Transactional
    public void updateEducation(Long educationId, EducationDTO dto) {

        Education education = educationRepository.findById(educationId)
                .orElseThrow(() -> new RuntimeException("Education not found"));

        // Delegate to the mapper for updating all fields
        educationMapper.updateEntity(education, dto);
        
        educationRepository.save(education);
    }

    @Override
    @Transactional
    public void deleteEducation(Long educationId) {

        Education education = educationRepository.findById(educationId)
                .orElseThrow(() -> new RuntimeException("Education not found"));

        educationRepository.delete(education);
    }

    @Override
    @Transactional
    public void updateDisplayOrder(Long educationId, Integer newDisplayOrder) {
        Education education = educationRepository.findById(educationId)
                .orElseThrow(() -> new RuntimeException("Education not found"));
        
        education.setDisplayOrder(newDisplayOrder);
        educationRepository.save(education);
    }
}