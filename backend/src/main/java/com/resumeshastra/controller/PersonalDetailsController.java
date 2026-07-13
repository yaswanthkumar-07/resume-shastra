package com.resumeshastra.controller;

import com.resumeshastra.dto.PersonalDetailsDTO;
import com.resumeshastra.response.ApiResponse;
import com.resumeshastra.response.PersonalDetailsResponseDTO;
import com.resumeshastra.service.PersonalDetailsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resumes/personal")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class PersonalDetailsController {

    private final PersonalDetailsService personalDetailsService;

    @PostMapping
    public ResponseEntity<ApiResponse<PersonalDetailsResponseDTO>> createPersonalDetails(
            @Valid @RequestBody PersonalDetailsDTO dto) {

        PersonalDetailsResponseDTO result =
                personalDetailsService.savePersonalDetails(dto);

        ApiResponse<PersonalDetailsResponseDTO> response =
                ApiResponse.<PersonalDetailsResponseDTO>builder()
                        .status("SUCCESS")
                        .message("Personal details saved successfully")
                        .data(result)
                        .errors(List.of())
                        .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}