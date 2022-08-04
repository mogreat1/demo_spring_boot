package com.example.demo.teacher;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    
    @Id
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence")
    private Long id;
    private String fullName;
    private String title;
    private int salary;
}
