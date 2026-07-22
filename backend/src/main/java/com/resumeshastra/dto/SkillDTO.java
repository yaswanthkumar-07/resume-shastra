package com.resumeshastra.dto;

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

    private Long id;

    @NotBlank(message = "Category is required")
    private String category;

    @NotBlank(message = "Skill name is required")
    private String name;

    private Integer displayOrder;
}