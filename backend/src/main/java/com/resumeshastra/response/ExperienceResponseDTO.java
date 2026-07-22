package com.resumeshastra.response;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExperienceResponseDTO {

    private Long id;

    private String companyName;

    private String jobTitle;

    private String employmentType;

    private String location;

    private String startDate;

    private String endDate;

    private Boolean currentlyWorking;

    private String description;

    private Integer displayOrder;
}