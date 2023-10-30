package com.tdp.controller;

import com.tdp.exception.ClassLinkNotFoundException;
import com.tdp.model.ClassLink;
import com.tdp.service.ClassLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/link")
public class ClassLinkController {

    @Autowired
    private ClassLinkService classLinkService;

    @GetMapping("/getClassLinkById/{id}")
    public Optional<ClassLink> getClassLinkById(@PathVariable Long id){
        return classLinkService.getClassLinkById(id);
    }

    @GetMapping("/getAllClassLinks")
    public List<ClassLink> getAllClassLinks(){
        return classLinkService.getAllClassLinks();
    }

    @PostMapping("/createClassLink")
    public ClassLink createClassLink(@RequestBody ClassLink classLink){
        return classLinkService.createClassLink(classLink);
    }

    @PutMapping("/editClassLink/{id}")
    public ClassLink updateClassLink(@PathVariable Long id, @RequestBody ClassLink updatedClassLink) throws ClassLinkNotFoundException {
        return classLinkService.updateClassLink(id, updatedClassLink);
    }

    @DeleteMapping("/deleteClassLink/{id}")
    public void deleteClassLink(@PathVariable Long id){
        classLinkService.deleteClassLink(id);
    }
}
