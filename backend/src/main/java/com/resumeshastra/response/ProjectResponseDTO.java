package com.resumeshastra.response;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectResponseDTO {

    private Long id;

    private String projectName;

    private String description;

    private String technologies;

    private String githubUrl;

    private String liveUrl;

    private Boolean featured;

    private Integer displayOrder;
}