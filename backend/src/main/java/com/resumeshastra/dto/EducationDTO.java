package com.resumeshastra.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EducationDTO {

    @NotBlank(message = "Education level is required")
    @Size(max = 50)
    private String educationLevel;

    @Size(max = 50)
    private String customEducationLevel;

    @NotBlank(message = "Degree is required")
    @Size(max = 100)
    private String degree;

    @Size(max = 100)
    private String customDegree;

    @Size(max = 100)
    private String branch;

    @Size(max = 100)
    private String major;

    @Size(max = 100)
    private String minor;

    @Size(max = 100)
    private String specialization;

    @NotBlank(message = "Institution is required")
    @Size(max = 150)
    private String institution;

    @Size(max = 150)
    private String universityBoard;

    @NotBlank(message = "Score type is required")
    private String scoreType;

    @DecimalMin(value = "0.0", message = "Score cannot be less than 0")
    @DecimalMax(value = "100.0", message = "Score cannot be greater than 100")
    private Double score;

    private String startMonth;

    private Integer startYear;

    private String endMonth;

    private Integer endYear;

    private Boolean currentlyStudying;

    private String description;

    private Integer displayOrder;
}