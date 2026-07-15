package com.resumeshastra.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkillDTO {

    @NotBlank(message = "Skill name is required")
    private String skillName;

    @NotBlank(message = "Category is required")
    private String category;

    @Min(value = 1, message = "Proficiency must be at least 1")
    @Max(value = 100, message = "Proficiency cannot exceed 100")
    private Integer proficiency;

    private Integer displayOrder;
}