package com.resumeshastra.controller;

import com.resumeshastra.dto.SaveSummaryDTO;
import com.resumeshastra.response.SummaryResponseDTO;
import com.resumeshastra.service.SummaryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resumes/{resumeId}/summary")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class SummaryController {

    private final SummaryService summaryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SummaryResponseDTO saveSummary(
            @PathVariable Long resumeId,
            @Valid @RequestBody SaveSummaryDTO dto
    ) {
        return summaryService.saveSummary(resumeId, dto);
    }

    @GetMapping
    public SummaryResponseDTO getSummary(
            @PathVariable Long resumeId
    ) {
        return summaryService.getSummary(resumeId);
    }

    @PutMapping
    public SummaryResponseDTO updateSummary(
            @PathVariable Long resumeId,
            @Valid @RequestBody SaveSummaryDTO dto
    ) {
        return summaryService.updateSummary(resumeId, dto);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSummary(
            @PathVariable Long resumeId
    ) {
        summaryService.deleteSummary(resumeId);
    }
}