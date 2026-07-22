package com.resumeshastra.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EducationResponseDTO {

    private Long id;

    private String educationLevel;

    private String customEducationLevel;

    private String degree;

    private String customDegree;

    private String branch;

    private String major;

    private String minor;

    private String specialization;

    private String institution;

    private String universityBoard;

    private String scoreType;

    private Double score;

    private String startMonth;

    private Integer startYear;

    private String endMonth;

    private Integer endYear;

    private Boolean currentlyStudying;

    private String description;

    private Integer displayOrder;
}