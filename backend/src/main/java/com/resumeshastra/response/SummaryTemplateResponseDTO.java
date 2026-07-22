package com.resumeshastra.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SummaryTemplateResponseDTO {

    private Long id;

    private String title;

    private String careerCategory;

    private String jobRole;

    private String experienceLevel;

    private String templateText;

}