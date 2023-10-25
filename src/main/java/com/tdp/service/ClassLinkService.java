package com.tdp.service;

import com.tdp.exception.ClassLinkNotFoundException;
import com.tdp.model.ClassLink;
import com.tdp.repository.ClassLinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ClassLinkService {

    @Autowired
    private ClassLinkRepository classLinkRepository;

    public Optional<ClassLink> getClassLinkById(Long id){
        return classLinkRepository.findById(id);
    }

    public List<ClassLink> getAllClassLinks(){
        return classLinkRepository.findAll();
    }

    public ClassLink createClassLink(ClassLink classLink){
        return classLinkRepository.save(classLink);
    }

    public ClassLink updateClassLink(Long id, ClassLink updatedClassLink) throws ClassLinkNotFoundException {
        Optional<ClassLink> existingClassLink = classLinkRepository.findById(id);

        if (existingClassLink.isPresent()) {
            ClassLink classLink = existingClassLink.get();
            classLink.setLink(updatedClassLink.getLink());
            classLink.setDateTime(updatedClassLink.getDateTime());
            return classLinkRepository.save(classLink);
        } else {
            throw new ClassLinkNotFoundException();
        }
    }

    public void deleteClassLink(Long id){
        classLinkRepository.deleteById(id);
    }
}
