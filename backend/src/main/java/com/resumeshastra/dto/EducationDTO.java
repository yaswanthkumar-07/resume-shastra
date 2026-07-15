package com.resumeshastra.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EducationDTO {

    @NotBlank(message = "Degree is required")
    @Size(max = 100, message = "Degree cannot exceed 100 characters")
    private String degree;

    @NotBlank(message = "Institution is required")
    @Size(max = 150, message = "Institution cannot exceed 150 characters")
    private String institution;

    @Size(max = 100, message = "Field of study cannot exceed 100 characters")
    private String fieldOfStudy;

    @DecimalMin(value = "0.0", message = "CGPA cannot be negative")
    @DecimalMax(value = "10.0", message = "CGPA cannot be greater than 10")
    private Double cgpa;

    private String startDate;

    private String endDate;

    private Boolean currentlyStudying;

    @Size(max = 1000, message = "Description cannot exceed 1000 characters")
    private String description;

    private Integer displayOrder;
}