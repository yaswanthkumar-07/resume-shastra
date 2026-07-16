package com.resumeshastra.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "experiences")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;

    private String jobTitle;

    private String employmentType;

    private String location;

    private String startDate;

    private String endDate;

    private Boolean currentlyWorking;

    @Column(length = 1000)
    private String description;

    private Integer displayOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id", nullable = false)
    private Resume resume;
}