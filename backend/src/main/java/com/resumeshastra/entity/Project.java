package com.resumeshastra.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "projects")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String projectName;

    @Column(length = 1000)
    private String description;

    private String technologies;

    private String githubUrl;

    private String liveUrl;

    private Boolean featured;

    private Integer displayOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id", nullable = false)
    private Resume resume;
}