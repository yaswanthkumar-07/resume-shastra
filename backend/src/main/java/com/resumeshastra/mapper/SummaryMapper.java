package com.resumeshastra.mapper;

import com.resumeshastra.entity.ProfessionalSummary;
import com.resumeshastra.response.SummaryResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class SummaryMapper {

    public SummaryResponseDTO toResponse(ProfessionalSummary summary) {

        if (summary == null) {
            return null;
        }

        return SummaryResponseDTO.builder()
                .id(summary.getId())
                .summaryText(summary.getSummaryText())
                .build();
    }
}