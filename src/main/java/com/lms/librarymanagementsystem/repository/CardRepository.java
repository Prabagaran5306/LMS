package com.lms.librarymanagementsystem.repository;

import com.lms.librarymanagementsystem.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card,Integer> {
}
