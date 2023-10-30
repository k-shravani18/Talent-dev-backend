package com.tdp.service;

import com.tdp.exception.TraineeNotFoundException;
import com.tdp.model.Trainee;
import com.tdp.repository.TraineeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TraineeService {
    @Autowired
    private TraineeRepository traineeRepository;

    public Optional<Trainee> getTraineeById(Long id){
        return traineeRepository.findById(id);
    }

    public List<Trainee> getAllTrainees(){
        return traineeRepository.findAll();
    }

    public Trainee createTrainee(Trainee trainee){
        return traineeRepository.save(trainee);
    }

    public Trainee updateTrainee(Long id, Trainee updateTrainee) throws TraineeNotFoundException {
        Optional<Trainee> existingTrainee = traineeRepository.findById(id);

        if (existingTrainee.isPresent()){
            Trainee trainee = existingTrainee.get();
            trainee.setName(updateTrainee.getName());
            trainee.setInternStartDate(updateTrainee.getInternStartDate());
            trainee.setInternEndDate(updateTrainee.getInternEndDate());
            trainee.setInternCompleted(updateTrainee.isInternCompleted());

            return traineeRepository.save(trainee);
        } else {
            throw new TraineeNotFoundException("Trainee with ID " + id + " not found");
        }
    }

    public void deleteTrainee(Long id){
        traineeRepository.deleteById(id);
    }
}
