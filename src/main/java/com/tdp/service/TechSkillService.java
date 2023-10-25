package com.tdp.service;

import com.tdp.exception.TechSkillNotFoundException;
import com.tdp.model.TechSkill;
import com.tdp.repository.TechSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TechSkillService {
    @Autowired
    private TechSkillRepository techSkillRepository;

    public Optional<TechSkill> getSkillById(Long id){
        return techSkillRepository.findById(id);
    }
    public List<TechSkill> getAllSkills(){
        return techSkillRepository.findAll();
    }
    public TechSkill createSkill(TechSkill  techSkill){
        return techSkillRepository.save(techSkill);
    }
    public TechSkill updateSkill(Long id, TechSkill updateSkill) throws TechSkillNotFoundException {
        Optional<TechSkill> existingSkill =techSkillRepository.findById(id);

        if (existingSkill.isPresent()){
            TechSkill skill=existingSkill.get();
            skill.setName(updateSkill.getName());
            return techSkillRepository.save(skill);
        }else {
            throw new TechSkillNotFoundException();
        }
    }
    public void deleteSkill(Long id){
        techSkillRepository.deleteById(id);
    }

}
