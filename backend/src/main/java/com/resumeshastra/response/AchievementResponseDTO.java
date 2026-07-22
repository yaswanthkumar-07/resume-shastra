package com.resumeshastra.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AchievementResponseDTO {

    private Long id;

    private Long resumeId;

    private String title;

    private String organization;

    private LocalDate achievementDate;

    private String description;

    private Integer displayOrder;

}