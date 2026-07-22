package com.resumeshastra.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "resumes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    private String professionalTitle;

    private String email;

    private String phoneNumber;

    private String linkedinUrl;

    private String githubUrl;

    private String portfolioUrl;

    private String location;
    @OneToOne(
        mappedBy = "resume",
        cascade = CascadeType.ALL,
        orphanRemoval = true
)
    private ProfessionalSummary professionalSummary;

    @OneToMany(
            mappedBy = "resume",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @Builder.Default
    private List<Education> educations = new ArrayList<>();

    @OneToMany(
            mappedBy = "resume",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @Builder.Default
    private List<Skill> skills = new ArrayList<>();

    @OneToMany(
            mappedBy = "resume", 
            cascade = CascadeType.ALL, 
            orphanRemoval = true)
    @Builder.Default    
    private List<Certification> certifications = new ArrayList<>();
    
    @OneToMany(
            mappedBy = "resume", 
            cascade = CascadeType.ALL, 
            orphanRemoval = true
    )
    @Builder.Default
    private List<Experience> experiences = new ArrayList<>();
    
    @OneToMany(
            mappedBy = "resume",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @Builder.Default
    private List<Project> projects = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}