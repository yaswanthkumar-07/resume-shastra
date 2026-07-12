package com.resumeshastra.controller;

import com.resumeshastra.dto.PersonalDetailsDTO;
import com.resumeshastra.response.ApiResponse;
import com.resumeshastra.service.PersonalDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resumes/personal")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class PersonalDetailsController {

    private final PersonalDetailsService personalDetailsService;

    @PostMapping
    public ResponseEntity<ApiResponse> createPersonalDetails(
            @RequestBody PersonalDetailsDTO dto) {

        String message = personalDetailsService.savePersonalDetails(dto);

        ApiResponse response = new ApiResponse(
                "SUCCESS",
                message
        );

        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

}