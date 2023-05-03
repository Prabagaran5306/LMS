package com.lms.librarymanagementsystem.repository;

import com.lms.librarymanagementsystem.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    Author findByEmail(String email);// findBy

}
