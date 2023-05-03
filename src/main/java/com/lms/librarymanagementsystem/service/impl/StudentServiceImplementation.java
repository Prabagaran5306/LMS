package com.lms.librarymanagementsystem.service.impl;

import com.lms.librarymanagementsystem.DTO.requestDTO.StudentRequestDTO;
import com.lms.librarymanagementsystem.DTO.requestDTO.UpdateStudentMobRequestDTO;
import com.lms.librarymanagementsystem.DTO.responseDTO.CardResponseDTO;
import com.lms.librarymanagementsystem.DTO.responseDTO.StudentResponseDTO;
import com.lms.librarymanagementsystem.DTO.responseDTO.UpdateStudentMobNoResponseDTO;
import com.lms.librarymanagementsystem.Enum.CardStatus;
import com.lms.librarymanagementsystem.entity.Card;
import com.lms.librarymanagementsystem.entity.Student;
import com.lms.librarymanagementsystem.exceptions.StudentNotFoundException;
import com.lms.librarymanagementsystem.repository.StudentRepository;
import com.lms.librarymanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class StudentServiceImplementation implements StudentService {

    @Autowired
   StudentRepository studentRepository;


    @Override
    public String addStudent(StudentRequestDTO studentRequestDTO) {
        //generate a new card for the student
        Student student = new Student();
        student.setAge(studentRequestDTO.getAge());
        student.setName(studentRequestDTO.getName());
        student.setDepartment(studentRequestDTO.getDepartment());
        student.setMobNo((studentRequestDTO.getMobNo()));

        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setValidTill("2024-01-01");//
        card.setStudent(student);

        student.setCard(card);
        studentRepository.save(student);

        return "Student added succcesfully";
    }

    @Override
    public UpdateStudentMobNoResponseDTO updateMobNo(UpdateStudentMobRequestDTO updateStudentMobRequestDTO) throws StudentNotFoundException {
        Student student;
        try{
            student  = studentRepository.findById(updateStudentMobRequestDTO.getId()).get();
            student.setMobNo(updateStudentMobRequestDTO.getMobNo());
            Student updatedStudent = studentRepository.save(student);

            //prepare resonse dto
            UpdateStudentMobNoResponseDTO updateStudentMobNoResponseDTO = new UpdateStudentMobNoResponseDTO();
            updateStudentMobNoResponseDTO.setName(updatedStudent.getName());
            updateStudentMobNoResponseDTO.setMobNo(updatedStudent.getMobNo());
            return updateStudentMobNoResponseDTO;
        }
        catch (Exception e){
            throw new StudentNotFoundException("Invalid student id");
        }


    }
    @Override
    public StudentResponseDTO getStudentById(int id){
        Student student = studentRepository.findById(id).get();
        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
        studentResponseDTO.setId(student.getId());
        studentResponseDTO.setName(student.getName());
        studentResponseDTO.setDepartment(student.getDepartment());
        studentResponseDTO.setAge(student.getAge());
        studentResponseDTO.setMobNo(student.getMobNo());

        CardResponseDTO cardResponseDTO = new CardResponseDTO();
        cardResponseDTO.setIssueDate(student.getCard().getIssueDate());
        cardResponseDTO.setCardStatus(student.getCard().getCardStatus());
        cardResponseDTO.setUpdatesOn(student.getCard().getUpdatesOn());
        cardResponseDTO.setValidTill(student.getCard().getValidTill());
        cardResponseDTO.setId(student.getCard().getId());

        studentResponseDTO.setCardResponseDTO(cardResponseDTO);
        return studentResponseDTO;

    }
}
