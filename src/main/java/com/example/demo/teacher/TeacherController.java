package com.example.demo.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping(path = "{teacherFullName}")
    public Teacher getTeacher(@PathVariable("teacherFullName") String teacherFullName) {
       return teacherService.findTeacherByFullName(teacherFullName);
    }

    @PostMapping
    public void createTeacher(@RequestBody Teacher teacher) {
        teacherService.createTeacher(teacher);
    }

    @DeleteMapping(path = "{teacherId}")
    public void fireTeacher(@PathVariable("teacherId") Long teacherId) {
        teacherService.fireTeacher(teacherId);
    }

}
