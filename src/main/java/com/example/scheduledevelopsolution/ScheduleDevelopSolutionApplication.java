package com.example.scheduledevelopsolution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ScheduleDevelopSolutionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduleDevelopSolutionApplication.class, args);
    }

}
