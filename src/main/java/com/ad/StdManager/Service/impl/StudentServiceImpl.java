package com.ad.StdManager.Service.impl;

import com.ad.StdManager.Exceptions.NotFoundException;
import com.ad.StdManager.Model.Student;
import com.ad.StdManager.Repository.StudentRepository;
import com.ad.StdManager.Service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        super();
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(long id) {
        Optional<Student> student = studentRepository.findById(id);

        if(student.isPresent()){
            return student.get();
        }else {
            throw new NotFoundException("student","id",id);
        }
    }
}
