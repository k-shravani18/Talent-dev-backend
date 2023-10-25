package com.tdp.service;

import com.tdp.exception.PerformanceReportNotFoundException;
import com.tdp.model.PerformanceReport;
import com.tdp.model.Trainee;
import com.tdp.repository.PerformanceReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PerformanceReportService {

    @Autowired
    private PerformanceReportRepository performanceReportRepository;

    public Optional<PerformanceReport> getPerformanceReportById(Long id){
        return performanceReportRepository.findById(id);
    }

    public List<PerformanceReport> getAllPerformanceReports(){
        return performanceReportRepository.findAll();
    }

    public PerformanceReport createPerformanceReport(PerformanceReport performanceReport){
        return performanceReportRepository.save(performanceReport);
    }

    public PerformanceReport updatePerformanceReport(Long id, PerformanceReport updatedPerformanceReport) throws PerformanceReportNotFoundException {
        Optional<PerformanceReport> existingPerformanceReport = performanceReportRepository.findById(id);

        if (existingPerformanceReport.isPresent()) {
            PerformanceReport performanceReport = existingPerformanceReport.get();
            performanceReport.setTrainee(updatedPerformanceReport.getTrainee());
            performanceReport.setMonthYear(updatedPerformanceReport.getMonthYear());
            performanceReport.setScore(updatedPerformanceReport.getScore());
            return performanceReportRepository.save(performanceReport);
        } else {
            throw new PerformanceReportNotFoundException();
        }
    }

    public void deletePerformanceReport(Long id){
        performanceReportRepository.deleteById(id);
    }
}
