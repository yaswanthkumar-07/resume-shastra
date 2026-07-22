package com.resumeshastra.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "educations")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id", nullable = false)
    private Resume resume;

    @Column(nullable = false)
    private String educationLevel;

    private String customEducationLevel;

    @Column(nullable = false)
    private String degree;

    private String customDegree;

    private String branch;
    
    private String major;
    
    private String minor;
    
    private String specialization;

    @Column(nullable = false)
    private String institution;

    private String universityBoard;

    private String scoreType;

    private Double score;

    private String startMonth;

    private Integer startYear;

    private String endMonth;

    private Integer endYear;

    private Boolean currentlyStudying;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Integer displayOrder;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}