package com.resumeshastra.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaveSummaryDTO {

    @NotBlank(message = "Professional summary is required.")
    @Size(
            min = 30,
            max = 300,
            message = "Professional summary must be between 30 and 300 characters."
    )
    private String summaryText;
}