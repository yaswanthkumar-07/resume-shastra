package com.resumeshastra.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AchievementDTO {

    @NotBlank
    @Size(max = 120)
    private String title;

    @Size(max = 120)
    private String organization;

    private LocalDate achievementDate;

    @Size(max = 300)
    private String description;

    private Integer displayOrder;

}