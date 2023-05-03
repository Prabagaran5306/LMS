package com.lms.librarymanagementsystem.controller;

import com.lms.librarymanagementsystem.DTO.requestDTO.StudentRequestDTO;
import com.lms.librarymanagementsystem.DTO.requestDTO.UpdateStudentMobRequestDTO;
import com.lms.librarymanagementsystem.DTO.responseDTO.StudentResponseDTO;
import com.lms.librarymanagementsystem.DTO.responseDTO.UpdateStudentMobNoResponseDTO;
import com.lms.librarymanagementsystem.entity.Student;
import com.lms.librarymanagementsystem.exceptions.StudentNotFoundException;
import com.lms.librarymanagementsystem.repository.StudentRepository;
import com.lms.librarymanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;

    //create
    @PostMapping("/add")
    public String addStudent(@RequestBody StudentRequestDTO studentRequestDTO){

        return studentService.addStudent(studentRequestDTO);
    }
    @PutMapping("/update_mobile")
    public UpdateStudentMobNoResponseDTO updateMobNo(@RequestBody UpdateStudentMobRequestDTO updateStudentMobRequestDTO) throws StudentNotFoundException {
        return studentService.updateMobNo(updateStudentMobRequestDTO);
    }

    @GetMapping("/get_student")
    public StudentResponseDTO getStudentById(@RequestParam("id") int id){

        return studentService.getStudentById(id);
    }


}
