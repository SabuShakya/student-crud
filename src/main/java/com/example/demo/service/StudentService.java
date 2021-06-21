package com.example.demo.service;

import com.example.demo.dto.StudentRequestDTO;
import com.example.demo.dto.StudentResponseDTO;
import com.example.demo.entities.Student;

import java.util.List;

/**
 * @author Sabu Shakya
 * @email <sabu.shakya@f1soft.com>
 * @createdDate 2021/06/21
 */
public interface StudentService {

    String createStudent(StudentRequestDTO requestDTO);

    List<StudentResponseDTO> getAllStudents();
}
