package com.tdp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table
public class PerformanceReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne
//    private User user;
    @ManyToOne
    private Trainee trainee;

    @OneToOne
    private Assessment assessment;

    private LocalDate monthYear;
    private Double score;


}
