package com.lms.librarymanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "author")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    int age;

    @Column(unique = true)
    String email;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    List<Book> books = new ArrayList<>();
    //@OneToMany(mappedBy = "author",cascade = CascadeType.ALL)

}
