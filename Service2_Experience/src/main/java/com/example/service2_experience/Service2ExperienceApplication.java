package com.example.service2_experience;

import com.example.service2_experience.entities.Experience;
import com.example.service2_experience.repositories.ExperienceRepository;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Service2ExperienceApplication {
    private final ExperienceRepository experienceRepository;
    private final Faker faker = new Faker();
    public Service2ExperienceApplication(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(Service2ExperienceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            for (int i = 1; i <= 10; i++) {
                Experience experience = createFakeExperience();
                experienceRepository.save(experience);
            }
        };
    }
    private Experience createFakeExperience() {
        Experience experience = new Experience();
        experience.setCompannyName(faker.company().name()); // Tên công ty giả mạo
        experience.setFromDate(faker.date().past(10, java.util.concurrent.TimeUnit.DAYS).toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate()); // Ngày bắt đầu kinh nghiệm giả mạo
        experience.setToDate(faker.date().past(1, java.util.concurrent.TimeUnit.DAYS).toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate()); // Ngày kết thúc kinh nghiệm giả mạo
        return experience;
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
