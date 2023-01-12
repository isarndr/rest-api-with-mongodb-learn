package com.codewithisa.restapiwithmongodb.service;

import com.codewithisa.restapiwithmongodb.entity.Student;
import com.codewithisa.restapiwithmongodb.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
}
