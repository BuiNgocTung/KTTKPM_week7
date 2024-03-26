package com.example.service2_experience.repositories;

import com.example.service2_experience.entities.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience,Long> {
}
