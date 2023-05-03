package com.lms.librarymanagementsystem.entity;

import com.lms.librarymanagementsystem.Enum.Genre;
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
@Table(name = "book")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String title;

    @Enumerated(EnumType.STRING)
    Genre genre;

    int numberOfpages;

    int price;

    boolean isIssued;
    @ManyToOne
    @JoinColumn
    Author author;

    @ManyToOne
    @JoinColumn
    Card card;

    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    List<Transaction> transactionList = new ArrayList<>();

}
