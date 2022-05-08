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

//        return studentRepository.findById(id).orElseThrow(
//                () -> new NotFoundException("Student", "Id", id));
    }

    @Override
    public Student updateStudent(Student student, long id) {
        //Check given ID is exited
        Student exitingStudent = studentRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Student", "Id", id));

        exitingStudent.setFname(student.getFname());
        exitingStudent.setLname(student.getLname());

        //Save Student
        studentRepository.save(exitingStudent);
        return exitingStudent;
    }

    @Override
    public void deleteStudent(long id) {
        //Check given ID is exited
        studentRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Student", "Id", id));
        //Delete Student
        studentRepository.deleteById(id);
    }
}