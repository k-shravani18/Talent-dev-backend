package com.tdp.controller;

import com.tdp.exception.TrainerNotFoundException;
import com.tdp.model.Trainer;
import com.tdp.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/trainer")
public class TrainerController {
    @Autowired
    private TrainerService trainerService;

    @GetMapping("/getByTrainerId/{id}")
    public Optional<Trainer> getTrainerById(@PathVariable Long id){
        return trainerService.getTrainerById(id);
    }
    @GetMapping("/getAllTrainers")
    public List<Trainer> getAllTrainers(){
        return trainerService.getAllTrainers();
    }
    @PostMapping("/createTrainer")
    public Trainer createTrainer(@RequestBody Trainer  trainer){
        return trainerService.createTrainer(trainer);
    }
    @PutMapping("/editTrainer/{id}")
    public Trainer updateTrainer(@PathVariable Long id, @RequestBody Trainer updateTrainer) throws TrainerNotFoundException {
            return trainerService.updateTrainer(id,updateTrainer);
    }
    @DeleteMapping("/deleteTrainer/{id}")
    public void deleteTrainer(@PathVariable Long id){
        trainerService.deleteTrainer(id);
    }
}
