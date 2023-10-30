package com.tdp.controller;

import com.tdp.exception.PerformanceReportNotFoundException;
import com.tdp.model.PerformanceReport;
import com.tdp.service.PerformanceReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/performance")
public class PerformanceReportController {

    @Autowired
    private PerformanceReportService performanceReportService;

    @GetMapping("/getPerformanceReportById/{id}")
    public Optional<PerformanceReport> getPerformanceReportById(@PathVariable Long id){
        return performanceReportService.getPerformanceReportById(id);
    }

    @GetMapping("/getAllPerformanceReports")
    public List<PerformanceReport> getAllPerformanceReports(){
        return performanceReportService.getAllPerformanceReports();
    }

    @PostMapping("/createPerformanceReport")
    public PerformanceReport createPerformanceReport(@RequestBody PerformanceReport performanceReport){
        return performanceReportService.createPerformanceReport(performanceReport);
    }

    @PutMapping("/editPerformanceReport/{id}")
    public PerformanceReport updatePerformanceReport(@PathVariable Long id, @RequestBody PerformanceReport updatedPerformanceReport) throws PerformanceReportNotFoundException {
        return performanceReportService.updatePerformanceReport(id, updatedPerformanceReport);
    }

    @DeleteMapping("/deletePerformanceReport/{id}")
    public void deletePerformanceReport(@PathVariable Long id){
        performanceReportService.deletePerformanceReport(id);
    }
}
