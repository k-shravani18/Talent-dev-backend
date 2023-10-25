package com.tdp.service;

import com.tdp.exception.TrainerNotFoundException;
import com.tdp.exception.UserNotFoundException;
import com.tdp.model.Trainer;
import com.tdp.model.User;
import com.tdp.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerService {
    @Autowired
    private TrainerRepository trainerRepository;

    public Optional<Trainer> getTrainerById(Long id){
        return trainerRepository.findById(id);
    }
    public List<Trainer> getAllTrainers(){
        return trainerRepository.findAll();
    }
    public Trainer createTrainer(Trainer  trainer){
        return trainerRepository.save(trainer);
    }
    public Trainer updateTrainer(Long id, Trainer updateTrainer) throws TrainerNotFoundException {
        Optional<Trainer> existingTrainer =trainerRepository.findById(id);

        if (existingTrainer.isPresent()){
            Trainer trainer=existingTrainer.get();
            trainer.setName(updateTrainer.getName());
            trainer.setTrainees(updateTrainer.getTrainees());
            trainer.setTechSkills(updateTrainer.getTechSkills());
            return trainerRepository.save(trainer);
        }else {
            throw new TrainerNotFoundException();
        }
    }
    public void deleteTrainer(Long id){
        trainerRepository.deleteById(id);
    }

}
