package com.example.demo.controller;

import com.example.demo.dto.StudentRequestDTO;
import com.example.demo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createStudent(@RequestBody StudentRequestDTO requestDTO) {
        String message = studentService.createStudent(requestDTO);
        if (message != null || message != "") {
            return ResponseEntity.ok(message);
        }
        return new ResponseEntity<String>("error", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update")
    public String updateStudent() {
        return "Hi";
    }

}
