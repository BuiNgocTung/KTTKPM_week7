package com.example.service2_experience.controllers;

import com.example.service2_experience.entities.Experience;
import com.example.service2_experience.services.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ExperienceController {
    @Autowired
    private ExperienceService experienceService;
    @GetMapping("/experience")
    public List<Experience> getLisOrder(){

        return    experienceService.getListExperience();
    }
    @GetMapping("/experience/{id}")
    public Experience getUserById(@PathVariable(value = "id") long id){
        return experienceService.getExperienceById(id);
    }
    @PostMapping("/experience")
    public Experience addExperience(@RequestBody Experience experience) {
        return experienceService.addExperience(experience);
    }


}
