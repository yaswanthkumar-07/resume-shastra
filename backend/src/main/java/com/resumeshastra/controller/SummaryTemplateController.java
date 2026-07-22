package com.resumeshastra.controller;

import com.resumeshastra.response.SummaryTemplateResponseDTO;
import com.resumeshastra.service.SummaryTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/summary-templates")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class SummaryTemplateController {

    private final SummaryTemplateService summaryTemplateService;

    @GetMapping
    public List<SummaryTemplateResponseDTO> getTemplatesByCategory(
            @RequestParam String category
    ) {

        return summaryTemplateService.getTemplatesByCategory(category);
    }

    @GetMapping("/{id}")
    public SummaryTemplateResponseDTO getTemplate(
            @PathVariable Long id
    ) {

        return summaryTemplateService.getTemplate(id);
    }
}