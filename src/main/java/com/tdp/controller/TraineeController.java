package com.tdp.controller;

import com.tdp.exception.TraineeNotFoundException;
import com.tdp.model.Trainee;
import com.tdp.service.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/trainee")
public class TraineeController {
    @Autowired
    private TraineeService traineeService;

    @GetMapping("/getById/{id}")
    public Optional<Trainee> getTraineeById(@PathVariable Long id){
        return traineeService.getTraineeById(id);
    }

    @GetMapping("/getAll")
    public List<Trainee> getAllTrainees(){
        return traineeService.getAllTrainees();
    }

    @PostMapping("/create")
    public Trainee createTrainee(@RequestBody Trainee trainee){
        return traineeService.createTrainee(trainee);
    }

    @PutMapping("/update/{id}")
    public Trainee updateTrainee(@PathVariable Long id, @RequestBody Trainee updateTrainee) throws TraineeNotFoundException {
        return traineeService.updateTrainee(id, updateTrainee);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTrainee(@PathVariable Long id){
        traineeService.deleteTrainee(id);
    }
}
