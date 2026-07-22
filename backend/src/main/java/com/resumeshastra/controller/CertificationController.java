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

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/certifications")
@RequiredArgsConstructor
public class CertificationController {

    private final CertificationService certificationService;

    @PostMapping("/{resumeId}")
    public ResponseEntity<ApiResponse<CertificationResponseDTO>> saveCertification(
            @PathVariable Long resumeId,
            @Valid @RequestBody CertificationDTO dto) {

        CertificationResponseDTO response = certificationService.saveCertification(resumeId, dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.<CertificationResponseDTO>builder()
                        .status("SUCCESS") // Updated to String
                        .message("Certification saved successfully")
                        .data(response)
                        .errors(Collections.emptyList())
                        .build()
        );
    }

    @GetMapping("/{resumeId}")
    public ResponseEntity<ApiResponse<List<CertificationResponseDTO>>> getCertifications(
            @PathVariable Long resumeId) {

        List<CertificationResponseDTO> response = certificationService.getCertifications(resumeId);

        return ResponseEntity.ok(
                ApiResponse.<List<CertificationResponseDTO>>builder()
                        .status("SUCCESS") // Updated to String
                        .message("Certifications fetched successfully")
                        .data(response)
                        .errors(Collections.emptyList())
                        .build()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CertificationResponseDTO>> updateCertification(
            @PathVariable Long id,
            @Valid @RequestBody CertificationDTO dto) {

        CertificationResponseDTO response = certificationService.updateCertification(id, dto);

        return ResponseEntity.ok(
                ApiResponse.<CertificationResponseDTO>builder()
                        .status("SUCCESS") // Updated to String
                        .message("Certification updated successfully")
                        .data(response)
                        .errors(Collections.emptyList())
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteCertification(@PathVariable Long id) {
        
        certificationService.deleteCertification(id);

        return ResponseEntity.ok(
                ApiResponse.<Void>builder()
                        .status("SUCCESS") // Updated to String
                        .message("Certification deleted successfully")
                        .data(null)
                        .errors(Collections.emptyList())
                        .build()
        );
    }
}