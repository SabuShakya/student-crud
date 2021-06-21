package com.example.demo.service;

import com.example.demo.dto.StudentRequestDTO;
import com.example.demo.dto.StudentResponseDTO;
import com.example.demo.entities.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<StudentResponseDTO> getAllStudents() {
        // map List<Student> to  List<StudentResponseDTO>
        List<StudentResponseDTO> studentDatas = studentList
                .stream()
                .map(student -> {
                    StudentResponseDTO responseDTO = new StudentResponseDTO();

                    responseDTO.setId(student.getId());
                    responseDTO.setName(student.getName());
                    responseDTO.setRollNo(student.getRollNo());

                    return responseDTO;
                })
                .collect(Collectors.toList());

//        List<StudentResponseDTO> students = new ArrayList<>();
//        for (int i = 0; i < studentList.size(); i++) {
//            StudentResponseDTO responseDTO = new StudentResponseDTO();
//            Student student = studentList.get(i);
//
//            responseDTO.setId(student.getId());
//            responseDTO.setName(student.getName());
//            responseDTO.setRollNo(student.getRollNo());
//
//            students.add(responseDTO);
//        }
        return studentDatas;
    }

    /// get by username; add username

    // update student with username
}
