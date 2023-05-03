package com.lms.librarymanagementsystem.service;

import com.lms.librarymanagementsystem.DTO.requestDTO.StudentRequestDTO;
import com.lms.librarymanagementsystem.DTO.requestDTO.UpdateStudentMobRequestDTO;
import com.lms.librarymanagementsystem.DTO.responseDTO.StudentResponseDTO;
import com.lms.librarymanagementsystem.DTO.responseDTO.UpdateStudentMobNoResponseDTO;
import com.lms.librarymanagementsystem.entity.Student;
import com.lms.librarymanagementsystem.exceptions.StudentNotFoundException;

public interface StudentService {

    public String addStudent(StudentRequestDTO studentRequestDTO);

    public UpdateStudentMobNoResponseDTO updateMobNo(UpdateStudentMobRequestDTO updateStudentMobRequestDTO) throws StudentNotFoundException;

    public StudentResponseDTO getStudentById(int id);
}
