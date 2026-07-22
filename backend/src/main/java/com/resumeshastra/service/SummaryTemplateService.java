package com.resumeshastra.service;

import com.resumeshastra.response.SummaryTemplateResponseDTO;

import java.util.List;

public interface SummaryTemplateService {

    List<SummaryTemplateResponseDTO> getTemplatesByCategory(String category);

    SummaryTemplateResponseDTO getTemplate(Long id);

}