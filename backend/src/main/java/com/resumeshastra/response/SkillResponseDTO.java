package com.resumeshastra.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkillResponseDTO {
    private Long id;
    private Long resumeId;
    
    // Updated these fields to match the guide!
    private String name;
    private String level;
    
    private String category;
    private Integer displayOrder;
}