package com.example.service2_experience.services;

import com.example.service2_experience.entities.Experience;
import com.example.service2_experience.entities.User;
import com.example.service2_experience.repositories.ExperienceRepository;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
public class ExperienceService {
    private final ExperienceRepository experienceRepository;
    private final RestTemplate restTemplate;

    public ExperienceService(ExperienceRepository experienceRepository, RestTemplate restTemplate) {
        this.experienceRepository = experienceRepository;
        this.restTemplate = restTemplate;
    }

    @Retry(name = "retryApi")
    public List<Experience> getListExperience(){
        List<Experience> experienceList = experienceRepository.findAll();
        for (Experience e: experienceList) {
            User user = restTemplate.getForObject("http://localhost:8082/api/v1/users/"+e.getId(), User.class);
            e.setUser(user);
        }
        return experienceList;
    }

    public Experience getExperienceById(long id){
        Experience experience = experienceRepository.findById(id).get();
        User user = restTemplate.getForObject("http://localhost:8082/api/v1/users/"+id, User.class);
        experience.setUser(user);
        return experience;
    }

    public Experience addExperience(Experience experience){
        return experienceRepository.save(experience);
    }

    public void deleteExperienceById(long id){
        experienceRepository.deleteById(id);
    }
}
