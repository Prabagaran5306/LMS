package com.lms.librarymanagementsystem.entity;

import com.lms.librarymanagementsystem.Enum.CardStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "card")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @CreationTimestamp
    Date issueDate;

    @UpdateTimestamp
    Date updatesOn;

    @Enumerated(EnumType.STRING)
    CardStatus cardStatus;

    String validTill;

    @OneToOne
    @JoinColumn
    Student student;

    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    List<Book> bookIssued = new ArrayList<>();

    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    List<Transaction> transactionList = new ArrayList<>();
}
