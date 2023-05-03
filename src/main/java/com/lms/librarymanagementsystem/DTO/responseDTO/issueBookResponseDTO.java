package com.lms.librarymanagementsystem.DTO.responseDTO;

import com.lms.librarymanagementsystem.Enum.TransactionStatus;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class issueBookResponseDTO {
    String transactionNumber;
    TransactionStatus transactionStatus;
    String bookName;

}
