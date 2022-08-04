package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository ){
        return args -> {
            Student max = new Student(
                    1L,
                    "Max",
                    "max@email.com",
                    LocalDate.of(2002, 12, 12)
            );

            Student karl = new Student(
                    2L,
                    "Karl",
                    "karl@email.com",
                    LocalDate.of(2011, 12, 12)
            );
            repository.saveAll(List.of(max, karl));
        };
    }
}
