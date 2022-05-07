package com.ad.StdManager.Service.impl;

import com.ad.StdManager.Model.Student;
import com.ad.StdManager.Repository.StudentRepository;
import com.ad.StdManager.Service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
}
