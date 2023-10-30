package com.tdp.controller;

import com.tdp.exception.AssessmentNotFoundException;
import com.tdp.model.Assessment;
import com.tdp.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/assessment")
public class AssessmentController {

    @Autowired
    private AssessmentService assessmentService;

    @GetMapping("/getAssessmentById/{id}")
    public Optional<Assessment> getAssessmentById(@PathVariable Long id){
        return assessmentService.getAssessmentById(id);
    }

    @GetMapping("/getAllAssessments")
    public List<Assessment> getAllAssessments(){
        return assessmentService.getAllAssessments();
    }

    @PostMapping("/createAssessment")
    public Assessment createAssessment(@RequestBody Assessment assessment){
        return assessmentService.createAssessment(assessment);
    }

    @PutMapping("/editAssessment/{id}")
    public Assessment updateAssessment(@PathVariable Long id, @RequestBody Assessment updatedAssessment) throws AssessmentNotFoundException {
        return assessmentService.updateAssessment(id, updatedAssessment);
    }

    @DeleteMapping("/deleteAssessment/{id}")
    public void deleteAssessment(@PathVariable Long id){
        assessmentService.deleteAssessment(id);
    }
}
