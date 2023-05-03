package com.lms.librarymanagementsystem.service;

import com.lms.librarymanagementsystem.DTO.requestDTO.issueBookRequestDTO;
import com.lms.librarymanagementsystem.DTO.responseDTO.issueBookResponseDTO;

public interface TransactionService {
    public issueBookResponseDTO issueBook(issueBookRequestDTO IssueBookRequest) throws Exception;
}
