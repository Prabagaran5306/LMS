package com.lms.librarymanagementsystem.service.impl;

import com.lms.librarymanagementsystem.entity.Author;
import com.lms.librarymanagementsystem.entity.Book;
import com.lms.librarymanagementsystem.repository.AuthorRepository;
import com.lms.librarymanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImplementations implements BookService {
    @Autowired
    AuthorRepository authorRepository;

    @Override
    public String addBook(Book book) throws Exception {

        Author author ;

        try{
            author = authorRepository.findById(book.getAuthor().getId()).get();
        }
        catch (Exception e){
            throw new Exception("Author Not Present");
        }

        author.getBooks().add(book);
        book.setAuthor(author);

        authorRepository.save(author);
        return "Book Added Successfully";
    }
}
