package com.ad.StdManager.Controller;

import com.ad.StdManager.Model.Student;
import com.ad.StdManager.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    //REST API

    //Post Entity
    @PostMapping // http://localhost:8080/api/students   -   POST
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
    }

    //Get all Entities
    @GetMapping // http://localhost:8080/api/students   -   GET
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    //Get Entity by ID
    @GetMapping("{id}") // http://localhost:8080/api/students/1   -   GET
    public ResponseEntity<Student> getStudentById(@PathVariable("id") long id){
        return new ResponseEntity<Student>(studentService.getStudentById(id),HttpStatus.OK);
    }

    //Update Entity
    @PutMapping("{id}") // http://localhost:8080/api/students/1   -   PUT
    public ResponseEntity<Student> updateStudent(@PathVariable("id") long id,@RequestBody Student student){
        return new ResponseEntity<Student>(studentService.updateStudent(student,id),HttpStatus.OK);
    }

    //Delete Entity
}