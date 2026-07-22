package com.resumeshastra.service;

import com.resumeshastra.dto.SaveSummaryDTO;
import com.resumeshastra.response.SummaryResponseDTO;

public interface SummaryService {

    SummaryResponseDTO saveSummary(Long resumeId, SaveSummaryDTO dto);

    SummaryResponseDTO getSummary(Long resumeId);

    SummaryResponseDTO updateSummary(Long resumeId, SaveSummaryDTO dto);

    void deleteSummary(Long resumeId);
}