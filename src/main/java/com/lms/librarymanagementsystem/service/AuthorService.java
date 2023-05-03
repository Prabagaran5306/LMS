package com.lms.librarymanagementsystem.service;

import com.lms.librarymanagementsystem.DTO.responseDTO.AuthorResponseDTO;
import com.lms.librarymanagementsystem.entity.Author;

public interface AuthorService {
    public String addAuthor(Author author);
    public AuthorResponseDTO getByEmail(String email);
}
