package com.resumeshastra.service.impl;

import com.resumeshastra.dto.SaveSummaryDTO;
import com.resumeshastra.entity.ProfessionalSummary;
import com.resumeshastra.entity.Resume;
import com.resumeshastra.mapper.SummaryMapper;
import com.resumeshastra.repository.ProfessionalSummaryRepository;
import com.resumeshastra.repository.ResumeRepository;
import com.resumeshastra.response.SummaryResponseDTO;
import com.resumeshastra.service.SummaryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class SummaryServiceImpl implements SummaryService {

    private final ProfessionalSummaryRepository professionalSummaryRepository;
    private final ResumeRepository resumeRepository;
    private final SummaryMapper summaryMapper;

    @Override
    public SummaryResponseDTO saveSummary(Long resumeId, SaveSummaryDTO dto) {

        Resume resume = resumeRepository.findById(resumeId)
                .orElseThrow(() ->
                        new EntityNotFoundException("Resume not found with id: " + resumeId));

        ProfessionalSummary summary = professionalSummaryRepository
                .findByResumeId(resumeId)
                .orElse(new ProfessionalSummary());

        summary.setResume(resume);
        summary.setSummaryText(dto.getSummaryText());

        ProfessionalSummary savedSummary = professionalSummaryRepository.save(summary);

        return summaryMapper.toResponse(savedSummary);
    }

    @Override
    @Transactional(readOnly = true)
    public SummaryResponseDTO getSummary(Long resumeId) {

        ProfessionalSummary summary = professionalSummaryRepository
                .findByResumeId(resumeId)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Professional summary not found for resume id: " + resumeId));

        return summaryMapper.toResponse(summary);
    }

    @Override
    public SummaryResponseDTO updateSummary(Long resumeId, SaveSummaryDTO dto) {

        ProfessionalSummary summary = professionalSummaryRepository
                .findByResumeId(resumeId)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Professional summary not found for resume id: " + resumeId));

        summary.setSummaryText(dto.getSummaryText());

        ProfessionalSummary updatedSummary = professionalSummaryRepository.save(summary);

        return summaryMapper.toResponse(updatedSummary);
    }

    @Override
    public void deleteSummary(Long resumeId) {

        ProfessionalSummary summary = professionalSummaryRepository
                .findByResumeId(resumeId)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Professional summary not found for resume id: " + resumeId));

        professionalSummaryRepository.delete(summary);
    }
}