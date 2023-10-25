package com.tdp.controller;

import com.tdp.exception.TechSkillNotFoundException;
import com.tdp.model.TechSkill;
import com.tdp.service.TechSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/tech-skill")
public class  TechSkillController {
    @Autowired
    private TechSkillService techSkillService;

    @GetMapping("/getBySkillId/{id}")
    public Optional<TechSkill> getSkillById(@PathVariable Long id){
        return techSkillService.getSkillById(id);
    }
    @GetMapping("/getAllSkills")
    public List<TechSkill> getAllSkills(){
        return techSkillService.getAllSkills();
    }
    @PostMapping("/createSkill")
    public TechSkill createSkill(@RequestBody TechSkill  techSkill){
        return techSkillService.createSkill(techSkill);
    }
    @PutMapping("/updateSkill/{id}")
    public TechSkill updateSkill(@PathVariable Long id, @RequestBody TechSkill updateSkill) throws TechSkillNotFoundException {
        return techSkillService.updateSkill(id,updateSkill);
    }
    @DeleteMapping("/deleteSkill/{id}")
    public void deleteSkill(@PathVariable Long id){
        techSkillService.deleteSkill(id);
    }
}
