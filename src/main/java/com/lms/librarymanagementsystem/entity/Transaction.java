package com.lms.librarymanagementsystem.entity;

import com.lms.librarymanagementsystem.Enum.TransactionStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transaction")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String transactionNumber;

    @CreationTimestamp
    Date transactionDate;

    boolean isIssueOperation;

    @Enumerated(EnumType.STRING)
    TransactionStatus transactionStatus;

    @ManyToOne
    @JoinColumn
    Card card;

    @ManyToOne
    @JoinColumn
    Book book;
}
