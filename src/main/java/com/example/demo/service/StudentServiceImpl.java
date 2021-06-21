package com.example.demo.service;

import com.example.demo.dto.StudentRequestDTO;
import com.example.demo.entities.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sabu Shakya
 * @email <sabu.shakya@f1soft.com>
 * @createdDate 2021/06/21
 */
@Service
public class StudentServiceImpl implements StudentService {

    private List<Student> studentList = new ArrayList<>();

    @Override
    public String createStudent(StudentRequestDTO requestDTO) {
        Student student = new Student();

        student.setId((long) (Math.floor(Math.random())) * 100);
        student.setName(requestDTO.getName());
        student.setRollNo(requestDTO.getRollNo());

        studentList.add(student);
//        repository.save(student);
        return "Student saved successfully.";
    }
}
