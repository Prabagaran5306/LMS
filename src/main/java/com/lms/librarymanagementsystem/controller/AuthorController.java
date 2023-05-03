package com.lms.librarymanagementsystem.controller;

import com.lms.librarymanagementsystem.DTO.responseDTO.AuthorResponseDTO;
import com.lms.librarymanagementsystem.entity.Author;
import com.lms.librarymanagementsystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("author")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public String addAuthor(@RequestBody Author author){
        return authorService.addAuthor(author);
    }
    @GetMapping("/get_by_email")
    public AuthorResponseDTO getAuthorByEmail(@RequestParam("email") String email){
        return authorService.getByEmail(email);
    }
}
