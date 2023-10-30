package com.tdp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table
public class Assessment {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @ManyToOne
//    private TechSkill skill;
    private LocalDate date;
    @OneToMany
    private List<TechSkill> skill;

//    @ManyToOne
//    private Trainee trainee;
//    private Double score;
}
