package com.resumeshastra.controller;

import com.resumeshastra.dto.CertificationDTO;
import com.resumeshastra.response.ApiResponse;
import com.resumeshastra.response.CertificationResponseDTO;
import com.resumeshastra.service.CertificationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resumes/{resumeId}/certifications")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class CertificationController {

    private final CertificationService certificationService;

    @PostMapping
    public ResponseEntity<ApiResponse<CertificationResponseDTO>> saveCertification(
            @PathVariable Long resumeId,
            @Valid @RequestBody CertificationDTO dto) {

        Long certificationId = certificationService.saveCertification(resumeId, dto);

        CertificationResponseDTO result = CertificationResponseDTO.builder()
                .certificationId(certificationId)
                .build();

        ApiResponse<CertificationResponseDTO> response =
                ApiResponse.<CertificationResponseDTO>builder()
                        .status("SUCCESS")
                        .message("Certification saved successfully")
                        .data(result)
                        .errors(List.of())
                        .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}