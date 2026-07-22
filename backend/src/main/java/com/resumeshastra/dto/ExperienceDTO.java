package com.resumeshastra.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExperienceDTO {

    @NotBlank(message = "Company name is required")
    private String companyName;

    @NotBlank(message = "Job title is required")
    private String jobTitle;

    private String employmentType;

    private String location;


    private Boolean currentlyWorking;

    @Size(max = 1000, message = "Description cannot exceed 1000 characters")
    private String description;

    private Integer displayOrder;
}