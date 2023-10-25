package com.tdp.service;

import com.tdp.exception.AssessmentNotFoundException;
import com.tdp.model.Assessment;
import com.tdp.repository.AssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssessmentService {

    @Autowired
    private AssessmentRepository assessmentRepository;

    public Optional<Assessment> getAssessmentById(Long id){
        return assessmentRepository.findById(id);
    }

    public List<Assessment> getAllAssessments(){
        return assessmentRepository.findAll();
    }

    public Assessment createAssessment(Assessment assessment){
        return assessmentRepository.save(assessment);
    }

    public Assessment updateAssessment(Long id, Assessment updatedAssessment) throws AssessmentNotFoundException {
        Optional<Assessment> existingAssessment = assessmentRepository.findById(id);

        if (existingAssessment.isPresent()) {
            Assessment assessment = existingAssessment.get();
            assessment.setSkill(updatedAssessment.getSkill());
            assessment.setTrainee(updatedAssessment.getTrainee());
            assessment.setScore(updatedAssessment.getScore());
            return assessmentRepository.save(assessment);
        } else {
            throw new AssessmentNotFoundException();
        }
    }

    public void deleteAssessment(Long id){
        assessmentRepository.deleteById(id);
    }
}
