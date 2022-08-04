package com.example.demo.teacher;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TeacherConfig {

    @Bean
    CommandLineRunner commandLineRunnerTeacher(TeacherRepository repository ){
        return args -> {
            Teacher max = new Teacher(
                    1L,
                    "MaxO",
                    "Professor",
                    50000
            );

            repository.saveAll(List.of(max));
        };
    }
}
