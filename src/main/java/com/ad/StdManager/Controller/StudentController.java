package com.ad.StdManager.Controller;

import com.ad.StdManager.Service.StudentService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
}
