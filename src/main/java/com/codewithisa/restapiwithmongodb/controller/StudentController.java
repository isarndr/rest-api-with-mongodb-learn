package com.codewithisa.restapiwithmongodb.controller;

import com.codewithisa.restapiwithmongodb.entity.Student;
import com.codewithisa.restapiwithmongodb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    List<Student> getStudents(){
        return studentService.getStudents();
    }
}
