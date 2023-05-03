package com.lms.librarymanagementsystem.entity;

import com.lms.librarymanagementsystem.Enum.Department;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id; // pk

    String name;

    int age;

    @Enumerated(EnumType.STRING)
    Department department;

    String mobNo;

    @OneToOne(mappedBy = "student",cascade=CascadeType.ALL)
    Card card;

}
