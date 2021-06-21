package com.example.demo.controller;

import com.example.demo.dto.StudentRequestDTO;
import com.example.demo.dto.StudentResponseDTO;
import com.example.demo.entities.Student;
import com.example.demo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
//            return new ResponseEntity<String>(message, HttpStatus.OK);
        }
        return new ResponseEntity<String>("error", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<StudentResponseDTO>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PutMapping("/update")
    public String updateStudent() {
        return "Hi";
    }

}
