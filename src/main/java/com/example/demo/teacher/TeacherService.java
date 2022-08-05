package com.example.demo.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher findTeacherByFullName(String teacherFullName) {
        if (teacherFullName == null || teacherFullName.isEmpty() || teacherFullName.isBlank()) {
            throw new IllegalStateException("Teacher Full Name cannot be empty");
        }

        Teacher teacher = teacherRepository.findTeacherByFullName(teacherFullName);

        if (teacher == null) {
            throw new IllegalStateException("teacher with name " + teacherFullName + " doesn't exist");
        }

        return teacher;
    }

    public void createTeacher(Teacher teacher) {
        if (teacherRepository.findTeacherByFullName(teacher.getFullName()) != null) {
            throw new IllegalStateException("Teacher with such Full Name already exists: " + teacher.getFullName());
        }
        teacherRepository.save(teacher);
    }

    public void fireTeacher(Long teacherId) {
        teacherRepository.findById(teacherId)
                .orElseThrow(() -> new IllegalStateException("Teacher with id: " + teacherId + " doesn't exist"));

        teacherRepository.deleteById(teacherId);
    }
}
