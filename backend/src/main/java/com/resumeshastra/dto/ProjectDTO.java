package com.resumeshastra.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {

    @NotBlank(message = "Project name is required")
    private String projectName;

    @NotBlank(message = "Description is required")
    @Size(max = 1000, message = "Description cannot exceed 1000 characters")
    private String description;

    @NotBlank(message = "Technologies are required")
    private String technologies;

    private String githubUrl;

    private String liveUrl;

    private Boolean featured;

    private Integer displayOrder;
}