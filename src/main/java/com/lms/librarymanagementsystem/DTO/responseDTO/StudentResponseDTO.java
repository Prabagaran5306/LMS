package com.lms.librarymanagementsystem.DTO.responseDTO;


import com.lms.librarymanagementsystem.Enum.Department;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentResponseDTO {
    int id;
    String name;
    int age;
    Department department;
    String mobNo;
    CardResponseDTO cardResponseDTO;


}
