package com.lms.librarymanagementsystem.service.impl;

import com.lms.librarymanagementsystem.DTO.requestDTO.issueBookRequestDTO;
import com.lms.librarymanagementsystem.DTO.responseDTO.issueBookResponseDTO;
import com.lms.librarymanagementsystem.Enum.CardStatus;
import com.lms.librarymanagementsystem.Enum.TransactionStatus;
import com.lms.librarymanagementsystem.entity.Book;
import com.lms.librarymanagementsystem.entity.Card;
import com.lms.librarymanagementsystem.entity.Transaction;
import com.lms.librarymanagementsystem.repository.BookRepository;
import com.lms.librarymanagementsystem.repository.CardRepository;
import com.lms.librarymanagementsystem.repository.TransactionRepository;
import com.lms.librarymanagementsystem.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionServiceImplementation implements TransactionService {
    @Autowired
    CardRepository cardRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    private JavaMailSender emailSender;

    @Override
    public issueBookResponseDTO issueBook(issueBookRequestDTO IssueBookRequest) throws Exception {
        Transaction transaction = new Transaction();
        transaction.setTransactionNumber(String.valueOf(UUID.randomUUID()));
        transaction.setIssueOperation(true);


        Card card;
        try{
            card = cardRepository.findById(IssueBookRequest.getCardID()).get();
        }
        catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Invalid card id!!!!");

        }
        transaction.setCard(card);
        Book book;
        try{
            book = bookRepository.findById(IssueBookRequest.getBookID()).get();
        }
        catch(Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Invalid book id!!!!");
        }
        transaction.setBook(book);

        if(card.getCardStatus()!= CardStatus.ACTIVATED){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Card not Invalid!!!!");
        }
        if(book.isIssued() == true){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Book not available!!!!");
        }

        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        book.setIssued(true);
        book.setCard(card);
        book.getTransactionList().add(transaction);

        card.getBookIssued().add(book);
        card.getTransactionList().add(transaction);

        cardRepository.save(card); // saving card,book and transaction

        //prepare response DTO
        issueBookResponseDTO IssueBookResponseDTO = new issueBookResponseDTO();
        IssueBookResponseDTO.setBookName(book.getTitle());
        IssueBookResponseDTO.setTransactionNumber(transaction.getTransactionNumber());
        IssueBookResponseDTO.setTransactionStatus(transaction.getTransactionStatus());

        String text = "Congrats! "+card.getStudent().getName()+" you have been issued  the book" + book.getTitle();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@baeldung.com");
        message.setTo(card.getStudent().getMobNo());
        message.setSubject("Issue Book");
        message.setText(text);
        emailSender.send(message);

        return IssueBookResponseDTO;

    }

    //return book api


}
