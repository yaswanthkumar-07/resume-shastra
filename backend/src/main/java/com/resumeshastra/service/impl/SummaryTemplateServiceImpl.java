package com.resumeshastra.service.impl;

import com.resumeshastra.entity.SummaryTemplate;
import com.resumeshastra.mapper.SummaryTemplateMapper;
import com.resumeshastra.repository.SummaryTemplateRepository;
import com.resumeshastra.response.SummaryTemplateResponseDTO;
import com.resumeshastra.service.SummaryTemplateService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SummaryTemplateServiceImpl implements SummaryTemplateService {

    private final SummaryTemplateRepository summaryTemplateRepository;
    private final SummaryTemplateMapper summaryTemplateMapper;

    @Override
    @Transactional(readOnly = true)
    public List<SummaryTemplateResponseDTO> getTemplatesByCategory(String category) {

        return summaryTemplateRepository
                .findByCareerCategoryAndIsActiveTrue(category)
                .stream()
                .map(summaryTemplateMapper::toResponseDTO)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public SummaryTemplateResponseDTO getTemplate(Long id) {

        SummaryTemplate template = summaryTemplateRepository
                .findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Summary Template not found with id : " + id));

        return summaryTemplateMapper.toResponseDTO(template);
    }
}