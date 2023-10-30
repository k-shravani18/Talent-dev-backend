package com.tdp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table
public class Trainee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate internStartDate;
    private LocalDate internEndDate;
    private boolean internCompleted;

    @ManyToOne
    private Trainer trainer;

//    @OneToMany(mappedBy = "trainee")
//    private Set<Assessment> assessments = new HashSet<>();
    //    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "trainee_id")
//    private Set<Assessment> assessments = new HashSet<>();


    @OneToMany(mappedBy = "trainee")
    private Set<PerformanceReport> performanceReports = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "trainee_tech_skills",
            joinColumns = @JoinColumn(name = "trainee_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private Set<TechSkill> techSkills = new HashSet<>();
}
