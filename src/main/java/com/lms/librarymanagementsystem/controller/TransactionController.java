package com.lms.librarymanagementsystem.controller;

import com.lms.librarymanagementsystem.DTO.requestDTO.issueBookRequestDTO;
import com.lms.librarymanagementsystem.DTO.responseDTO.issueBookResponseDTO;
import com.lms.librarymanagementsystem.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping("/add")
    public issueBookResponseDTO issueBook(@RequestBody issueBookRequestDTO IssueBookReqquest) throws Exception {
        return transactionService.issueBook(IssueBookReqquest);
    }
}
