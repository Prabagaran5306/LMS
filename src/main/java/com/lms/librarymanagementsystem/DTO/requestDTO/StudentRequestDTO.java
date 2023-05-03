package com.lms.librarymanagementsystem.DTO.requestDTO;

import com.lms.librarymanagementsystem.DTO.responseDTO.CardResponseDTO;
import com.lms.librarymanagementsystem.Enum.Department;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentRequestDTO {

    String name;

    int age;

    Department department;

    String mobNo;

    CardResponseDTO cardResponseDTO;

}
